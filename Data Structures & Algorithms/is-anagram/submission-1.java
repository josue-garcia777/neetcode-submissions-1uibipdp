class Solution {

    //we can also just use a single map and decrease it, and just verify all values are 0 i guess is similar complexity
    public boolean isAnagram(String s, String t) {
      Map<Character, Integer> freqs = new HashMap<>();
      Map<Character, Integer> freqt = new HashMap<>();

      for (char c : s.toCharArray()){
        freqs.put(c, freqs.getOrDefault(c, 0)+1);
      }

      for (char c : t.toCharArray()){
        freqt.put(c, freqt.getOrDefault(c,0)+1);
      }

      if (freqs.size() != freqt.size()){
        return false;
      }

      for (Map.Entry<Character, Integer> entry : freqs.entrySet()){
        if(!entry.getValue().equals(freqt.get(entry.getKey()))){
            return false;
        }

      }
      return true;

    }
}