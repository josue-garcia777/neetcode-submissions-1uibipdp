class Solution {
    /*
             [2,7,11,15]
             l         r

        1) start at l=0 and r=n-1
        2) while not collide. check the sum
        3) if equal to target return res;
        4) if bigger than target move r--; else smaller move l++
    */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;

        while(l<r){
            int sum = numbers[l] + numbers[r];

            if(sum == target){
                return new int[]{l+1,r+1};
            }

            if(sum < target){
                l++;
            }else{
                r--;
            }
        }

        return new int[]{l+1, r+1};
    }
}
