class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        this.dp = new long[questions.length+1];
        Arrays.fill(dp, -1l);
       return helper(0, questions);
    }

    private long helper(int idx, int[][] ques){
        if(ques.length <= idx) return 0;
        if(dp[idx] != -1) return dp[idx];

        long take = helper(idx+ques[idx][1]+1, ques) + ques[idx][0];
        long dont = helper(idx+1, ques);

        dp[idx] = Math.max(take, dont);
        return dp[idx];
    }
}