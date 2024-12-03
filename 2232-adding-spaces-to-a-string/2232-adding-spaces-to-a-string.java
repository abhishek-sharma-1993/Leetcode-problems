class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int start = 0;
        for(int end: spaces){
            ans.append(s.substring(start,end));
            ans.append(" ");
            start = end;
        }
        ans.append(s.substring(start));
        return ans.toString();
    }
}