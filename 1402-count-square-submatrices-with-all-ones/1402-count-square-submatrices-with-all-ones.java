class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int ans = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 1){
                    dp[i+1][j+1] = Math.min(
                            dp[i+1][j],
                            Math.min(
                                dp[i][j+1],
                                dp[i][j]
                            )
                        )+1;
                }
                ans += dp[i+1][j+1];
            }
        }
        return ans;
    }
}