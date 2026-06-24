class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l = 0;

        while (l < word1.length() && l< word2.length()){
            sb.append(word1.charAt(l));
            sb.append(word2.charAt(l));
            l++;
        }

        while(l < word1.length()){
            sb.append(word1.charAt(l));
            l++;
        }

        while(l<word2.length()){
            sb.append(word2.charAt(l));
            l++;
        }

        return sb.toString();

    }

   

}