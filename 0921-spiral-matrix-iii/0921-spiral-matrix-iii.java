class Solution {
 
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows*cols][2];
        
        // Directions East.   South. West.   North
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int direction=0;
        int steps=1;
        int idx=0;

        while(idx<rows*cols){

            for(int i=0; i<2; i++){
                for(int j=0; j<steps; j++){

                    if(
                        rStart>=0 &&
                        rStart<rows &&
                        cStart>=0 &&
                        cStart<cols
                    ){
                        res[idx][0] = rStart;
                        res[idx][1] = cStart;
                        idx++;
                    }

                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }
                direction = (direction+1) % 4;
            }
            steps++;
        }

        return res;
    }

}