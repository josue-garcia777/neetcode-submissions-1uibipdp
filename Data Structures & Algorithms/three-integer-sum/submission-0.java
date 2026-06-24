class Solution {
    /*
        pick a number and apply two sum

        1) sort
        2) fixed a number
        3) check constrait for non duplicate number
        4) perform 2 sum if they add up to 0 add to response
            4.1) move l++; check that nums[l] and prev l-1 are equals if they are we move l++   

    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int fixed =0; fixed < n; fixed++){
            if(fixed != 0 && nums[fixed] == nums[fixed-1]){
                continue; //avoid adding duplicates.
            }

            int l = fixed +1;
            int r = n -1;

            while(l<r){
                int sum = nums[fixed] + nums[l] + nums[r];
                if(sum == 0){
                    result.add(List.of(nums[fixed], nums[l], nums[r]));
                    l++;

                    while(l < n && nums[l] == nums[l-1]){
                        l++;
                    }

                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }

        return result;   
    }
}
