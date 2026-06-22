class Solution {
    /*
        one naive option build number convert to int, sum 1. put it into output.
        reverse array

    */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n- 1; i >= 0; i--) {
    //If the current digit is not 9, we can safely add one and finish.
            if (digits[i] < 9) { 
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }
        //for cases like [9,9,9] we add new all digits will
        // become 0 and we add extra at the end.
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    
    }
}
