class Solution {
    //["1","2","+","C","5","D"]
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String s : operations){
            if(s.equals("+")){
               int top = stack.pop();
               int prv = stack.pop();
               stack.push(prv);
               stack.push(top);
               stack.push(top+prv);
               continue;
            }

            if(s.equals("C")){
                stack.pop();
                continue;
            }

            if(s.equals("D")){
                int top = stack.peek();
                stack.push(top*2);
                continue;
            }

            stack.push(Integer.parseInt(s));
        }

        int total = 0;

        while(!stack.isEmpty()){
            total += stack.pop();
        }

        return total;
    }
}