class Solution {
    int[] dirX = {-1,0,1};
    int[] dirY = {1,1,1};
    int[][] dp;
    public int maxMoves(int[][] grid) {
        int ans = 0;
        int row = grid.length, col = grid[0].length;
        this.dp = new int[row+1][col+1];
        for(int i=0; i<row; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=0; i<row; i++){
            ans =Math.max(ans, dfs(i,0,grid));
        }
        return ans;
    }
    
    private int dfs(int row, int col, int[][] grid){
        if(dp[row][col] != -1) return dp[row][col];
        int steps = 0;
        for(int i=0; i<3; i++){
            int nrow = row+dirX[i];
            int ncol = col+dirY[i];

            if(nrow>=0 && nrow<grid.length
                && ncol>=0 && ncol<grid[0].length
                    && grid[row][col] < grid[nrow][ncol]){
                        steps = Math.max(steps,dfs(nrow, ncol, grid)+1);
                    }
        }
        dp[row][col] = steps;
        return steps;
    }
}