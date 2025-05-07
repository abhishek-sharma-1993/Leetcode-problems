class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int N = moveTime.length;
        int M = moveTime[0].length;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        // Queue<int[]> heap = new LinkedList<>();
        heap.add(new int[]{0,0,0});

        int[] dirX = {0,1,-1,0};
        int[] dirY = {1,0,0,-1};

        int minTime = Integer.MAX_VALUE;
        visited[0][0] = true;
        while(!heap.isEmpty()){
            int[] room = heap.poll();
            int row = room[0], col = room[1], time = room[2];
            

            if(row == N-1 && col == M-1){
                return time;
            }
                
            
            for(int i=0; i<4; i++){
                int nrow = dirX[i]+row;
                int ncol = dirY[i]+col;

                if(nrow<N && nrow>=0 && ncol<M && ncol>=0 
                    && !visited[nrow][ncol]){
                        visited[nrow][ncol] = true;
                        int ntime = time + Math.max(0, moveTime[nrow][ncol] - time)+1;
                        heap.add(new int[]{nrow, ncol, ntime});
                    }
            }
        }

        return minTime;
    }
}