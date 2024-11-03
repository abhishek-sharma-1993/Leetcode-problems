class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i=0; i<s.length(); i++){
            String left = s.substring(0, i+1);
            String right = s.substring(i+1);
            String shifted = right+left;

            if(shifted.equals(goal)) return true;
        }
        return false;
    }
}