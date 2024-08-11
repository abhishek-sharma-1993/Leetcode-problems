class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int R = grid.length;
        int C = grid.length;

        int ans = 0;
        for(int i=0; i+2 <R; i++){
            for(int j=0; j+2 <C; j++){
                
                if(isMagicGrid(grid, i, j))
                    ans++;
            }
        }
        return ans;
    }

    private boolean isMagicGrid(int[][] grid, int row, int col){

        int[] seen = new int[10];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                int num = grid[row+i][col+j];

                if(num<1 || num>9) return false;
                if(seen[num]==1) return false;

                seen[num] = 1;
            }
        }

        int diagonal1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int diagonal2 = grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col];
        
        if(diagonal1 != diagonal2) return false;

        int row1 = grid[row][col]+ grid[row][col+1]+ grid[row][col+2];
        int row2 = grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2];
        int row3 = grid[row+2][col]+ grid[row+2][col+1]+ grid[row+2][col+2];

        if(row1 != row2 || row1 != row3 || row2 != row3) return false;
        if(row1 != diagonal1) return false;

        int col1 = grid[row][col] + grid[row+1][col] + grid[row+2][col];
        int col2 = grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1];
        int col3 = grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2];

        if(col1 != col2 || col1 != col3 || col2 != col3) return false;
        if(row1 != col1) return false;

        return true;
    }
}