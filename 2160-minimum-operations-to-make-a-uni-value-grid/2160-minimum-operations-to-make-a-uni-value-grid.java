class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int len = n*m;
        int[] input = new int[len];
        int i = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                input[i++] = grid[r][c];
            }
        }

        Arrays.sort(input);
        int mid = input[len/2];
        int ans = 0;
        for(int num: input){
            if(num%x != mid%x) return -1;

            ans += Math.abs(mid - num) / x;
        }
        return ans;

    }
}

