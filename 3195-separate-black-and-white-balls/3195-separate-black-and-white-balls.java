class Solution {
    public long minimumSteps(String s) {
        long ans = 0, zero = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i=n-1; i>=0; i--){
            if(chars[i] == '0')
                zero++;
            else 
                ans+= zero;
        }
        return ans;
    }
}