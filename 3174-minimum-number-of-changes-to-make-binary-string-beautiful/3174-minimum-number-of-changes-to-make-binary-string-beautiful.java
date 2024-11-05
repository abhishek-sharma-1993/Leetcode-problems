class Solution {
    public int minChanges(String s) {
        int ans = 0, ones = 0, zeros = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0') zeros++;
            if(s.charAt(i) == '1') ones++;

            int index = i+1;
            if(index%2 == 0){
                ans += Math.min(ones, zeros);
                ones = 0;
                zeros = 0;
            }
        }
        return ans;
    }
}