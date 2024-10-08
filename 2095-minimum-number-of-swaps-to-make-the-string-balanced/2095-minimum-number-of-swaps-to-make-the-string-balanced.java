class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int unbalanced = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '['){
                stack.push(ch);
            }else{
                if(!stack.empty())
                    stack.pop();
                else
                    unbalanced++;
            }
        }

        return (unbalanced+1)/2;
    }
}