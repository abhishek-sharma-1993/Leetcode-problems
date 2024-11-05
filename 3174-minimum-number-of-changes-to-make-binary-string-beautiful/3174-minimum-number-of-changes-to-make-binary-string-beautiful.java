class Solution {
    public int minChanges(String s) {
        int ans = 0, ones = 0, zeros = 0;
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '0') zeros++;
            if(chars[i] == '1') ones++;

            int index = i+1;
            if((index & 1) == 0){
                if(ones<zeros)
                    ans += ones;
                else
                    ans += zeros;
                
                ones = 0;
                zeros = 0;
            }
        }
        return ans;
    }
}