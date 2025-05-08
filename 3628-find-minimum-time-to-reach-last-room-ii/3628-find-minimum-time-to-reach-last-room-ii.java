class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // int N = moveTime.length;
        // int M = moveTime[0].length;
        // Queue<int[]> queue = new LinkedList<>();
        // int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        // int[][] time = new int[N][M];
        // for(int[] row: time){
        //     Arrays.fill(row, Integer.MAX_VALUE);
        // }
        // queue.add(new int[]{0,0,1});
        // time[0][0] = 0;

        // while(!queue.isEmpty()){
        //     int[] node = queue.poll();
        //     int r = node[0], c = node[1], step = node[2];

        //     for(int i=0; i<4; i++){
        //         int nrow = dir[i][0] + r;
        //         int ncol = dir[i][1] + c;

        //         if(nrow>=0 && nrow<N && ncol>=0 && ncol<M){
        //             int ntime = Math.max(0,moveTime[nrow][ncol] - time[r][c]) + time[r][c];
        //             ntime += step%2==0 ? 2: 1;

        //             if(time[nrow][ncol]>ntime){
        //                 time[nrow][ncol] = ntime;
        //                 queue.add(new int[]{nrow, ncol, step+1});
        //             }
        //         }
                
        //     }
        // }
        // return time[N-1][M-1];


        int N = moveTime.length;
        int M = moveTime[0].length;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        heap.add(new int[]{0,0,0,1});

        int[] dirX = {0,1,-1,0};
        int[] dirY = {1,0,0,-1};

        int minTime = Integer.MAX_VALUE;
        visited[0][0] = true;
        while(!heap.isEmpty()){
            int[] room = heap.poll();
            int row = room[0], col = room[1], time = room[2], step = room[3];
            

            if(row == N-1 && col == M-1){
                return time;
            }
                
            
            for(int i=0; i<4; i++){
                int nrow = dirX[i]+row;
                int ncol = dirY[i]+col;

                if(nrow<N && nrow>=0 && ncol<M && ncol>=0 
                    && !visited[nrow][ncol]){
                        visited[nrow][ncol] = true;
                        int ntime = time + Math.max(0, moveTime[nrow][ncol] - time);
                        ntime += step%2 == 0 ? 2:1;
                        heap.add(new int[]{nrow, ncol, ntime, step+1});
                    }
            }
        }

        return minTime;
    }
}