class Solution {
    /*
        total sum = include on expand.
        once a total sum is >= target then shrink until is less than target 
        - cause we want to get the min val
    
        keep the min window size
    */
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int totalsum =0;
        int l =0;

        for (int r=0; r<nums.length; r++){
            totalsum += nums[r];

            while (totalsum >= target){
                min = Math.min(min, (r-l)+1);
                totalsum -= nums[l];
                l++;
            }
        }

        if (min == Integer.MAX_VALUE){
            return 0;
        }

        return min;
    }
}