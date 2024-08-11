class Solution {

    int rows;
    boolean[][] visited;
    int[] dirX = {-1, 0, 1, 0};
    int[] dirY = {0, -1, 0, 1};

    public int regionsBySlashes(String[] grid){
        this.rows = grid.length;
        this.visited = new boolean[rows*3][rows*3];
        int[][] graph = new int[rows*3][rows*3];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if(c == '/'){
                    graph[i*3][j*3+2] = 1;
                    graph[i*3+1][j*3+1] = 1;
                    graph[i*3+2][j*3] = 1;
                }else if(c == '\\'){
                    graph[i*3][j*3] = 1;
                    graph[i*3+1][j*3+1] = 1;
                    graph[i*3+2][j*3+2] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] == 0 && !visited[i][j]){
                    dfs(graph, i, j, visited);
                    ans++;
                }

            }
        }

        return ans;
    }

    private void dfs(int[][] graph, int row, int col, boolean[][] visited){
        visited[row][col] = true;

        for(int k = 0; k < 4; k++){
            int newRow = row + dirX[k];
            int newCol = col + dirY[k];

            if(newRow>=0 && newRow< graph.length
            && newCol>=0 && newCol< graph[newRow].length
                    && !visited[newRow][newCol]
                    && graph[newRow][newCol] == 0){
                dfs(graph, newRow, newCol, visited);
            }
        }
    }
}