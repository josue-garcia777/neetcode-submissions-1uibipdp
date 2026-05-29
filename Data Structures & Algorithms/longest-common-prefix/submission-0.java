class Solution {
    /*
        find the minWord
        iterate from 0 to len(minWord) idx
            for every prev, next word
                check if prev.chars(idx) != next.chars(idx)
                    return substring(0, idx)
        idx++
        return minword;
                  
    */
    public String longestCommonPrefix(String[] strs) {
        String minWord = getMinWord(strs);
        int idx =0;

        while(idx< minWord.length()){
            for (int i=1; i<strs.length; i++){
                String prev = strs[i-1];
                String next = strs[i];

                if(prev.charAt(idx) != next.charAt(idx)){
                    return minWord.substring(0, idx);
                }
            }

            idx++;
        }

        return minWord;
    
    }

    private String getMinWord(String[] strs){
        String smallest = strs[0];
        for(String s : strs){
            if(s.length() < smallest.length()){
                smallest = s;
            }
        }

        return smallest;
    }
}