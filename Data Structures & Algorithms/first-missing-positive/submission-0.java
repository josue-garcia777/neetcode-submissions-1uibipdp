class Solution {
    public int firstMissingPositive(int[] nums) {
        //easiest will be add them into set, check start from 0 until we find one not in set
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }
        
        for(int i=1; i<100.000; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

    private int max(int[] nums){
        int max = 0;

        for(int n : nums){
            max = Math.max(max, n);
        }

        return max;
    }
}