class Solution {
    int N;
    int[] piles;
    int[][] dp;
    public int stoneGameII(int[] piles) {
        this.N = piles.length;
        this.piles = piles;
        this.dp = new int[N+1][N+1];

        for(int i=N-2; i>=0; i--)
            piles[i] += piles[i+1];

        return helper(0,1);
    }

    private int helper(int i, int M){
        if(i+2*M>=N) return piles[i];
        if(dp[i][M] != 0) return dp[i][M];

        int ans = Integer.MAX_VALUE;
        for(int j=1; j<=2*M; j++){
            int tmp = helper(i+j, Math.max(M,j));
            ans = Math.min(ans, tmp);
        }
        dp[i][M] = piles[i]-ans;
        return dp[i][M];
    }
}