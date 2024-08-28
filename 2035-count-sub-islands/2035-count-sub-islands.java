class Solution {
    int[][] grid1;
    int[][] grid2;
    int R,C;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.R = grid2.length;
        this.C = grid2[0].length;

        int subIlands = 0;
        boolean[][] visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && grid2[i][j] == 1 && grid1[i][j] == 1){
                    boolean isSubIsland = dfs(i,j,visited);
                    if(isSubIsland) subIlands++;
                }
            }
        }
        return subIlands;
    }
    int[] Xdir = {1,0,-1,0};
    int[] Ydir = {0,1,0,-1};
    private boolean dfs(int row, int col, boolean[][] visited){
        visited[row][col] = true;
        boolean isSubIland = true;

        if(grid1[row][col] == 0)
            isSubIland = false;

        for(int i=0; i<4; i++){
            int nrow = row+Xdir[i];
            int ncol = col+Ydir[i];

            if(nrow>=0 && nrow < R && ncol>=0 && ncol < C
                && !visited[nrow][ncol] && grid2[nrow][ncol] == 1){
                
                boolean nextSubIland = dfs(nrow, ncol, visited);
                isSubIland = isSubIland & nextSubIland;
            }
        }
        return isSubIland;
    }
}