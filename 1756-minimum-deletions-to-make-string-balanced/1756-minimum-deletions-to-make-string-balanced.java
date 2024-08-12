class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();

        int numDeletion = 0;
        stack.push(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == 'b' && ch == 'a'){
                stack.pop();
                numDeletion++;
            }else{
                stack.push(ch);
            }

        }

        return numDeletion;
    }
}