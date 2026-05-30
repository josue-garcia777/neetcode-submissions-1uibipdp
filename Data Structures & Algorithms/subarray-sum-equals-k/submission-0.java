class Solution {
    /*
        brute force:
        nums = [2,-1,1,2], k = 2
        subarray of all keep a sum.
    */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int sum = 0;

            for(int j=i; j<nums.length; j++){
                sum+=nums[j];

                if(sum == k){
                    count++;
                }
            }

        
        }

        return count;
    }
}