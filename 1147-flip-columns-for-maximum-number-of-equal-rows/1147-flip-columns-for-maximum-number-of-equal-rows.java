class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int ans = 0;

        for(int[] row: matrix){
            int[] flipped = new int[C];
            int tmp = 0;
            for(int i=0; i<C; i++){
                flipped[i] = 1-row[i];
            }

            for(int[] currRow: matrix){
                if(Arrays.equals(currRow, row) || 
                    Arrays.equals(currRow, flipped)){
                        tmp++;
                    }
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}

/*

[[0,0,0],
 [0,0,1],
 [1,1,0]
]

[[1,1,0],
 [1,1,1],
 [0,0,0]
]

*/