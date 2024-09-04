class Solution {
        private static final int HASH_MULTIPLIER = 60001;

        private int hash(int x, int y){
            return x * HASH_MULTIPLIER + y;
        }

        public int robotSim(int[] commands, int[][] obstacles) {

            Set<Integer> obstableSet = new HashSet<>();
            for(int[] obstacle : obstacles){
                obstableSet.add(hash(obstacle[0], obstacle[1]));
            }
            // 0 - North, 1 - East, 2 - South, 3 - West
            int[] dirX = {0, 1, 0, -1};
            int[] dirY = {1, 0, -1, 0};
            int dir = 0;  //starts facing north
            int n = commands.length;
            int posX = 0, posY = 0;
            int ans = 0;
            for(int i=0; i<n; i++){
                if(commands[i] == -1) {
                    dir = (dir+1) % 4;
                }else if(commands[i] == -2){
                    dir = (dir+3) % 4;
                }else{

                    for (int step = 0; step < commands[i]; step++) {
                        int nextPosX = posX+dirX[dir];
                        int nextPosY = posY+dirY[dir];
                        if(obstableSet.contains(hash(nextPosX, nextPosY))){
                            break;
                        }
                        posX = nextPosX;
                        posY = nextPosY;
                    }
                    ans = Math.max(ans,(posX*posX + posY*posY) );
                }
            }
            return ans;

        }
}