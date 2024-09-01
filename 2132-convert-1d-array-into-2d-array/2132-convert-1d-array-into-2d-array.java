class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int size = original.length;

        if(m*n != size) return new int[0][0];
        if(size%n != 0) return new int[0][0];

        int[][] ans = new int[m][n];
        int index = 0;
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                ans[r][c] = original[index++];
            }
        }
        return ans;
    }
}