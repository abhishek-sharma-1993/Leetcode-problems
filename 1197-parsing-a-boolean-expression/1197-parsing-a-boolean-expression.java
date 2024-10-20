class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for(char ch : expression.toCharArray()){
            // System.out.println("character :"+ch+" - ");
            if(ch == ',') continue;

            if(ch == ')'){

                List<Character> exp = new ArrayList<>();
                while(!stack.empty() && stack.peek() != '('){
                    exp.add(stack.pop());
                }
                // System.out.print("List : "+ exp+" - ");
                // System.out.print(stack+" - ");
                while(!stack.empty() 
                    && (stack.peek() !='&' && stack.peek() !='!' && stack.peek() !='|') 
                ){
                    stack.pop();
                }

                // System.out.print(stack+" - ");

                if(!stack.empty()){
                    char operator = stack.pop();

                    switch(operator){
                        case '&': stack.push(parseAnd(exp));break;
                        case '|': stack.push(parseOr(exp));break;
                        case '!': stack.push(parseNot(exp));break;
                    }
                }
                
            }else {
                stack.push(ch);
            }

            // System.out.print(stack);
            // System.out.println();
        }

        return stack.pop() == 't'?true:false;
    }
    private char parseOr(List<Character> chars){
        boolean ans = false;
        for(char ch: chars){
            ans |= ch=='f'?false:true;
        }
        return ans?'t':'f';
    }

    private char parseAnd(List<Character> chars){
        boolean ans = true;
        for(char ch: chars){
            ans &= ch=='f'?false:true;
        }
        return ans?'t':'f';
    }

    private char parseNot(List<Character> chars){
        char ch = chars.get(0);
        return ch=='f' ? 't': 'f';
    }
}