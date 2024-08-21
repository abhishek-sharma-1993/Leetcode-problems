class Solution {
    String str;
    int[][] dp;
    public int strangePrinter(String s) {
        this.str = removeDuplicate(s);
        int n = str.length();
        this.dp = new int[n][n];
        return minTurns(0,n-1);
    }

    private int minTurns(int start, int end){
        if(start>end) return 0;
        if(dp[start][end]!=0)return dp[start][end];

        int minTurns = 1 + minTurns(start+1, end);
        
        for(int k = start+1; k<=end; k++){
            if(str.charAt(k) == str.charAt(start)){
                int minTurnMatch = minTurns(start,k-1)+minTurns(k+1, end);
                minTurns = Math.min(minTurns, minTurnMatch);
            }    
        }
        
        dp[start][end] = minTurns;
        return minTurns;
    }

    private String removeDuplicate(String s){
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            str.append(ch);
            while(i<s.length() && s.charAt(i) == ch)
                i++;
        }
        
        return str.toString();
    }
}

//abbbba : a=2, b=4
/*
 * 
 *
*/