class Solution {
    /*
        The array is sorted, and the k closest elements must form a contiguous
	window of size k.
        
       to identify target we could use binary search should return closes value if not target value found. 
       then use 2 pointer solution.


    optimal: not search for target value but for the window it selft

        l=0
        r=len(arr)-k
        [ 1, 2, 3, 4, 5]
          l        r

        the idea is to check if next window
        is better than the left most value of the prev window.
        

        -------x------
            [   ]
               [   ]
            
            m will be the start of window

        Input: arr = [2,4,5,8], k = 2, x = 6

        Output: [4,5]
    
    */

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l =0, r=arr.length-k;

        while (l<r){
            int mid = (r+l)/2; //[ 1, 2, 3, 4, 5]
            
            //window next mid+k is better move m
            if (x - arr[mid] > arr[mid+k] - x ){
                l=mid+1;    
            } else {
                r=mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i=l; i<l+k; i++){
            res.add(arr[i]);
        }

        return res;
    }

    //two pointer is more intuitive
      public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l >= k) {//while invalid window find the closest by move right and left values
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                r--;
            } else {
                l++;
            }
        }
        //gather results from the valid window
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}