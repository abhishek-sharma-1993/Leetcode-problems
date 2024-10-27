class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                ans += helper(i, j, matrix, dp);
            }
        }
        return ans;
    }

    private int helper(int i, int j, int[][] grid, int[][] dp){
        if(i == grid.length || j == grid[0].length)
            return 0;
        
        if(grid[i][j] == 0)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int right = helper(i, j+1, grid, dp);
        int bottom = helper(i+1, j, grid, dp);
        int diagonal = helper(i+1, j+1, grid, dp);

        return dp[i][j] = Math.min(right, Math.min(bottom, diagonal)) + 1;
    }
}