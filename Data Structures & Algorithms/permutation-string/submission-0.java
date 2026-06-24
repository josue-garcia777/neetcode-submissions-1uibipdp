class Solution {
    /*
        have 2 maps
        window(s2) and have(s1)
        fill freq Map with s1
        sizeWIndow will be s1.length;

        check for fixed window if is valid (r-l) >= sizeWindow
        remove left most character from window, and from map

        add to window next character.
        compare both maps if they are equals return true


        return false;

    */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        int windowSize = s1.length();
        int l =0;

        for(char c : s1.toCharArray()){
            have.put(c, have.getOrDefault(c,0) +1);
        }

        for(int r=0; r<s2.length(); r++){
            
            if((r-l) >= windowSize){
                char left = s2.charAt(l);
                int val = window.getOrDefault(left, 0) -1;
                if(val == 0){
                    window.remove(left);
                }else{
                    window.put(left, val);
                }
                l++;
            }

            window.put(s2.charAt(r), window.getOrDefault(s2.charAt(r), 0) +1);

            if(window.equals(have)){
                return true;
            }

        }

        return false;
    }
}
