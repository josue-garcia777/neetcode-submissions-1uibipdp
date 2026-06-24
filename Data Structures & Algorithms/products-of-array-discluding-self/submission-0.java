class Solution {
    /*  
        prefix[i] * postfix[i+1]
        
        1 [1,2,4,6] 1
        prefix = [1, 1,2,8,48]
        postfix= [48,48,24,6,1]
        res=[1x48, 1x24, 2x6, 8]

     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        
        prefix[0]=1;
        
        for(int i=0; i<n; i++){
            prefix[i+1]= prefix[i] * nums[i];
        }

        int[] postfix = new int[n+1];
        postfix[n]=1;
        
        for(int i=n-1; i>=0; i--){
            postfix[i]= postfix[i+1] * nums[i];
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = prefix[i] * postfix[i+1];
        }
        return res;

    }
}  
