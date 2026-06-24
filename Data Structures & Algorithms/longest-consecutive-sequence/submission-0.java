class Solution {
    /*
        build a set with all the elements. then look for starts. it is a start if element +1 is not on the set
        once I find a start then iterate until have no consecutive elements on the set
        update a longest res variable
    */
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();

        for (int n : nums){
            elements.add(n);
        }
        int n = nums.length;
        int res = 0;

        for(int i=0; i<n;i++){
            if(elements.contains(nums[i]-1)){
                continue;
            }

            int idx = nums[i];
            int count = 0;
            while(elements.contains(idx)){
                idx++;
                count++;
            }

            res = Math.max(res, count);

        }

        return res;
    }
}
