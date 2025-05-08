class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int N = moveTime.length;
        int M = moveTime[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] time = new int[N][M];
        for(int[] row: time){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        queue.add(new int[]{0,0,1});
        time[0][0] = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0], c = node[1], step = node[2];

            for(int i=0; i<4; i++){
                int nrow = dir[i][0] + r;
                int ncol = dir[i][1] + c;

                if(nrow>=0 && nrow<N && ncol>=0 && ncol<M){
                    int ntime = Math.max(0,moveTime[nrow][ncol] - time[r][c]) + time[r][c];
                    ntime += step%2==0 ? 2: 1;

                    if(time[nrow][ncol]>ntime){
                        time[nrow][ncol] = ntime;
                        queue.add(new int[]{nrow, ncol, step+1});
                    }
                }
                
            }
        }
        return time[N-1][M-1];
    }
}