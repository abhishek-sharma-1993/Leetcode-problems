class Solution {
    int N;
    int M;
    public int minDays(int[][] grid) {
        this.N = grid.length;
        this.M = grid[0].length;
        int islands = noOfIlands(grid);
        if(islands > 1) 
            return 0;
        else if(islands == 0)
            return 0;
            
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(grid[r][c] == 1){
                    grid[r][c] = 0;

                    islands = noOfIlands(grid);
                    if(islands>1)
                        return 1;
                    else if(islands==0)
                        return 1;
                    else
                        grid[r][c] = 1;
                }
            }
        }

        return 2;
    }

    int[] dirX = {1,0,-1,0};
    int[] dirY = {0,1,0,-1};

    private int noOfIlands(int[][] grid){
        boolean[][] visited = new boolean[N][M];
        int island = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(!visited[r][c] && grid[r][c] == 1){
                    dfs(grid,r,c, visited);
                    island++;
                }
            }
        }
        return island;
    }
    private void dfs(int[][] grid, int row, int col, boolean[][] visited){
        visited[row][col]=true;

        for(int i=0; i<4; i++){
            int nRow = row+dirX[i];
            int nCol = col+dirY[i];

            if(inBound(nRow, nCol) 
            && !visited[nRow][nCol]
            && grid[nRow][nCol] == 1){
                dfs(grid,nRow,nCol,visited);
            }
        }
    }

    private boolean inBound(int row , int col){
        return (row>=0 && row<N && col>=0 && col<M);
    }
}