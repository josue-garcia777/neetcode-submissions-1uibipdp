class Solution {
    /*
        iterate array and have a idx value for if we find a value that is not equal to k we move it to front
    */
    public int removeElement(int[] nums, int k) {
        int idx = 0;
        for(int r=0; r<nums.length; r++){
            int val = nums[r];
            if(val != k){
                nums[idx] = val;
                idx++;
            }
        }

        return idx;
    }
}