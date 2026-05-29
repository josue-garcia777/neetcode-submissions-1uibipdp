class Solution {
    
    /*
        stack: [ (, { ]

    */
    public boolean isValid(String s) {
        Set<Character> opening = Set.of('(', '{', '[');

        Map<Character, Character> mapchar = Map.of('(', ')', '{', '}', '[', ']');
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if (opening.contains(c)){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                
                char open = stack.pop();
                if (mapchar.get(open) != c){
                    return false;
                }
            }
        } 

        return stack.isEmpty();
    }
}
