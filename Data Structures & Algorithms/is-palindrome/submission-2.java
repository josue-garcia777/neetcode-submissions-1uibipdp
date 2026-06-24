class Solution {
    public boolean isPalindrome(String s) {
        String sanitized = s.replaceAll("[,:?'.\\s]", "").trim().toLowerCase();
        int n = sanitized.length();
        System.out.println(sanitized);

        int l =0;
        int r = n-1;
        
        while(l <= r){
            if(sanitized.charAt(l) != sanitized.charAt(r)){
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
}
