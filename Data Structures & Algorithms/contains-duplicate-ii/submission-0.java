class Solution {

    //contains duplicate withing window?
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> el = new HashSet<>();
        int l=0;

        for(int r=0; r<nums.length; r++){
            if(Math.abs(r-l) > k){
                el.remove(nums[l]);
                l++;//move window
            }

            if(el.contains(nums[r])){
                return true;
            }

            el.add(nums[r]);
        }


        return false;
    }
}