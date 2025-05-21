class Solution {
    public String removeDuplicateLetters(String s) {
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!seen.contains(ch)){

                while(!stack.empty() && ch<stack.peek() && i<map.get(stack.peek())){
                    seen.remove(stack.pop());
                }

                seen.add(ch);
                stack.add(ch);
            }
        }

        StringBuilder str = new StringBuilder();
        for(char c : stack){
            str.append(c);
        }

        return str.toString();
    }
}