class Solution {
    int n;
    int[][] dp;
    public int minSteps(int n) {
        this.n = n;
        this.dp = new int[n+1][n+1];
        if(n == 1) return 0;
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return 1+dfs(1,1);
    }

    private int dfs(int paste, int copy ){
        if(paste == n) return 0;
        if(paste>n) return 1000;
        if(dp[paste][copy] != -1) return dp[paste][copy];

        int cstep = dfs(paste * 2, paste)+2;
        int pstep = dfs(paste+copy, copy)+1;
        dp[paste][copy] = Math.min(cstep,pstep);
        return dp[paste][copy];
    }
}