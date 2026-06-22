class Solution {
    /*
        do something like 1...x = to find x*x since we are looking to round down
        we can improve it by doing binary search and check if the res in bigger than x
        then move out pointer position to the middle of it. 
        if less we should update our candidate. and x == middle return.

    */
    public int mySqrt(int x) {
        int l =0;
        int r = x;
        int candidate = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;
            long value = (long) mid*mid;

            if (value == x){
                return mid;
            }

            if(value < x){
                candidate = mid;
                l = mid+1;
            } else {
                r = mid-1;
            } 
        }

        return candidate;
    }
}