class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        String tmp = s+s;

        if(tmp.indexOf(goal)!= -1) return true;

        return false;
    }
}