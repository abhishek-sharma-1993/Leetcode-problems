class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == 'B' ){
                if(!stack.empty() && stack.peek() == 'A'){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else if(ch == 'D'){
                if(!stack.empty() && stack.peek() == 'C'){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }

        return stack.size();
    }
}