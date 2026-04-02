class Solution {

    /** 
        
        "international", abbr = "i9l"
        i    

         word = "apple", abbr = "a3e"
                a 3 e
                  l                
                                   r
     */


    public boolean validWordAbbreviation(String word, String abbr) {
        //l in word, r in abrr.
        //if same world[l] != abbr[r] false
        //if abbr[r] is numeric
        //while val > 0 r++;
        int l=0; 
        int r=0;
        
        while ( r<abbr.length() && l<word.length()) {
            
            if(Character.isDigit(abbr.charAt(r))){
                if(abbr.charAt(r) == '0') return false;

                 StringBuilder sb = new StringBuilder();

                while(r < abbr.length() && Character.isDigit(abbr.charAt(r))){
                    sb.append(abbr.charAt(r));
                    r++;
                }

                int value = getValue(sb.toString());
                while(value > 0){
                    value--;
                    l++;
                }
                continue; 
             }

            
            if(abbr.charAt(r) != word.charAt(l)){
                return false;
            }

            l++;
            r++;
            
        }

        /*
            word="substitution"
            abbr="s55n"
        */

        return l == word.length() && r == abbr.length();
    }


  

    private int getValue(String value){
        return Integer.parseInt(value);
    }
}