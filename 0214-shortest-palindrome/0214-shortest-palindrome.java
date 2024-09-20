class Solution {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = new StringBuilder(s).append("#").append(reversed).toString();
        int N = combined.length();
        int[] LPS = new int[N];
        LPS[0] = 0;
        for(int i=1; i<N; i++){
            int x = LPS[i-1];
            while(combined.charAt(i) != combined.charAt(x)){
                if(x == 0){
                    x = -1;
                    break;
                }
                x = LPS[x-1];
            }
            LPS[i] = x+1;
        }

        int palidrome = LPS[N-1];
        return new StringBuilder(
            reversed.substring(0,reversed.length()-palidrome))
            .append(s)
            .toString();
    }
}