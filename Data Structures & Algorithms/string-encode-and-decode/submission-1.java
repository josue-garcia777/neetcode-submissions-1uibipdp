class Solution {
    /*
        "Hello","World"
        5#Hello5#World
    */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs){
            sb.append(s.length())
            .append("#")
            .append(s);
        }

        return sb.toString();
    }
    //5#Hello5#World
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int l = 0;
        while (l < str.length()){
            int r = l;

            while(str.charAt(r) != '#'){
                r++;
            }

            int length = Integer.parseInt(str.substring(l,r));
            int startOfWord = r +1;
            int endOfWord = startOfWord + length;
            res.add(str.substring(startOfWord, endOfWord));
            l = endOfWord;
        }

        return res;
    }
}
