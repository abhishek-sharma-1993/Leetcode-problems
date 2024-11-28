class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int[][] visited = new int[m][n];
        for(int[] arr: visited){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        heap.add(new int[]{0,0,0});
        int ans = Integer.MAX_VALUE;

        while(!heap.isEmpty()){
            int[] cell = heap.remove();
            int r = cell[0];
            int c = cell[1];
            int obsticle = cell[2];
            if(r==m-1 && c==n-1) return obsticle;

            for(int i=0; i<4; i++){
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];

                if(nr>=0 && nr<m && nc>=0 && nc<n ){
                    int tmp = obsticle + grid[nr][nc];
                    
                    if(visited[nr][nc]>tmp){
                        visited[nr][nc] = obsticle;
                        heap.add(new int[]{nr,nc,tmp});
                    }
                }
            }
        }

        return visited[m-1][n-1];
    }
}