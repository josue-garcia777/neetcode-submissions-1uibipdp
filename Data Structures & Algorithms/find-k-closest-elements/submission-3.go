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
func findClosestElements(arr []int, k int, x int) []int {
    l, r:= 0, len(arr)-k

    for l<r {
        mid := (l+r)/2
        if x-arr[mid] > arr[mid+k]-x { //start and outside window
            l=mid+1
        } else {
            r=mid
        }
    }

    return arr[l:l+k]
}

/*
    two pointer solution
*/
func findClosestElements2(arr []int, k int, x int) []int {
    l, r:= 0, len(arr)-1
    
    for r-l+1 > k {
        if abs(x-arr[l]) <= abs(x-arr[r]){
            r--
        }else{
            l++
        }
    }

    return arr[l:r+1]

}

func abs(x int) int{
    if x<0{
        return -x
    }
    return x
}