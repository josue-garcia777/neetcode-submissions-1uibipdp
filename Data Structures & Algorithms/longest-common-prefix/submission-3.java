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
        if (strs.length == 1) return strs[0];

        String minWord = getMinWord(strs);
        int n = minWord.length();
        int idx = 0;
        while (idx < n){
            for (int i=1; i<strs.length; i++){
                String prev = strs[i-1];
                String curr = strs[i];
                
                if(prev.charAt(idx) != curr.charAt(idx)){
                    return prev.substring(0, idx);
                }
            }
            idx++;
        }
        return minWord;
    }

    public String getMinWord(String[] strs){
        String word = strs[0];

        for (int i=1; i<strs.length; i++){
            if (strs[i].length() < word.length()){
                word = strs[i];
            }
        }

        return word;
    }

}