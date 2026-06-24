class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for (String s : strs){
            String key = getAnagramKey(s);

            if(!group.containsKey(key)){
                group.put(key, new ArrayList<>());
            }

            group.get(key).add(s);
        }

        return group.values().stream().toList();
    }

    public String getAnagramKey(String s){
        int[] bucket = new int[26];

        for (char c : s.toCharArray()){
            bucket[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++){
            if(bucket[i] != 0){
              
                sb.append(i + ":" + bucket[i]);
            }
        }

        return sb.toString();
    }
}
