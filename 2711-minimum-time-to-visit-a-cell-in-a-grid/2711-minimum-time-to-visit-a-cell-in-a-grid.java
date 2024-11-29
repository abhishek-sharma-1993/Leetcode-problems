class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        heap.add(new int[]{grid[0][0], 0, 0});
        
        while(!heap.isEmpty()){
            int[] cell = heap.remove();
            int row = cell[1], col = cell[2], time = cell[0];

            if(row == m-1 && col == n-1) return time;
            if(visited[row][col]) continue;

            visited[row][col] = true;
            
            for(int i=0; i<4; i++){
                int nrow = row+dir[i][0];
                int ncol = col+dir[i][1];

                if(nrow>=0 && nrow<m 
                    && ncol>=0 && ncol<n 
                    && !visited[nrow][ncol]){
                        int waiting = (grid[nrow][ncol] - time) % 2 == 0 ? 1:0;
                        int nextTime = Math.max(time+1, grid[nrow][ncol]+waiting);
                        heap.add(new int[]{nextTime, nrow, ncol});

                }
            }
        }

        return -1;
    }
}