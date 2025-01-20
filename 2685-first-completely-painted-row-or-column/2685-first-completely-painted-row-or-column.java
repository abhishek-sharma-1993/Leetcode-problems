class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int n = row*col;
        int[][] map = new int[n+1][2];
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                map[mat[r][c]][0] = r;
                map[mat[r][c]][1] = c;
            }
        }

        int[] rowFreq = new int[row];
        int[] colFreq = new int[col];

        for(int i=0; i<n; i++){
            int r = map[arr[i]][0];
            int c = map[arr[i]][1];

            rowFreq[r]++;
            colFreq[c]++;

            if(rowFreq[r] == col) return i;
            if(colFreq[c] == row) return i;
        }

        return -1;
    }
}