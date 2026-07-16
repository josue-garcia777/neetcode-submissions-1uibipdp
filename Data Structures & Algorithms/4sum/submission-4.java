class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> quad = new ArrayList<>();
        int n = nums.length;
        int k =4;
        Arrays.sort(nums);

        kSum(k, 0, (long) target, nums, quad);
        
        return res;
    }

    private void kSum(int k, int startidx, long target, int[] nums, List<Integer> quad){
        int n = nums.length;
        if (k != 2){
            for (int i=startidx; i<= n-k; i++){
                if (i > startidx && nums[i] == nums[i-1]){
                    continue;
                }

                quad.add(nums[i]);
                kSum(k-1, i+1, target - nums[i], nums, quad);
                quad.removeLast();
            }
            return;
        }

        //Two Sum
        int l = startidx, r=n-1;
        while (l<r) {
            long sum = (long) nums[l] + nums[r];
            if (sum < target){
                l++;
            } else if (sum > target){
                r--;
            } else {
                List<Integer> combination = new ArrayList<>(quad);
                combination.add(nums[l]);
                combination.add(nums[r]);
                
                res.add(combination);
                l++;
        
                while (l<r && nums[l] == nums[l-1]) l++;
                
            }
        }
    }
}