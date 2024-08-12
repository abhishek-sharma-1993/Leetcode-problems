class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();

        int numDeletion = 0;
        char[] charArr = s.toCharArray();

        for(char ch: charArr){
            
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