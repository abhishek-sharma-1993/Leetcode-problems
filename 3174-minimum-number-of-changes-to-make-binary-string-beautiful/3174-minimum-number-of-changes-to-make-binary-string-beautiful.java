class Solution {
    public int minChanges(String s) {
        int ans = 0, tmp = 0;
        for(int i=0; i<s.length(); i++){
            tmp += s.charAt(i) - '0';
            if((i & 1) != 0){
                ans += tmp%2;
                tmp = 0;
            }
        }
        return ans;
    }
}