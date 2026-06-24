class Solution {
    /*
         s = "A A B A B B A", k = 1
            l
                     r

        l=0; right=3  map: {A:3, B: 1}

        formula: length of window(r-l) - count[mostfreqchar] = num of char we need to replace
        res <= k we can keep expanding. 

        expand until window is valid. 

        Solution: 
        1) have a freqMap and update count on each char
        2) have a longestWindow and a maxFreqInWindow
        3) close window while( windowSize - maxFreqInWindow > k) formula windowSize - maxFreqInWindow > k
            decrease mostleft in windowMap
            l++
        4) update longest with windowSize;

    
    */
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int l = 0;
        int longest =0;
        int maxFreqInWindow = 0;

        for (int r =0; r<s.length(); r++){
            char c = s.charAt(r);
            freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
            maxFreqInWindow = Math.max(maxFreqInWindow, freqMap.get(c));

            //windowSize
            while( ((r-l)+1) - maxFreqInWindow > k){
                char mostLeft = s.charAt(l);
                freqMap.put(mostLeft, freqMap.get(mostLeft)-1);
                l++;
            }
            
            longest = Math.max(longest, (r-l) +1);
        }

        return longest;
    }
}
