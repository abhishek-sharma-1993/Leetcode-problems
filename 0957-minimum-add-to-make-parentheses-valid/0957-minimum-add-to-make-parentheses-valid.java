class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0, ans = 0;
        for(char ch :s.toCharArray()){
            if(ch == '(')
                open++;
            else
                close++;

            if(close>open){
                ans += close-open;
                open = close;
            }   
        }
        if(close != open) ans += open-close;
        return ans;
    }
}