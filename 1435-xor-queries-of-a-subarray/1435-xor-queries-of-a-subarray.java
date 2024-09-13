class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i] = prefix[i-1]^arr[i];
        }

        for(int i=0; i<n; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int xor = prefix[right];

            if(left>0){
                xor = xor ^ prefix[left-1];
            }
            ans[i] = xor;
        }
        return ans;
    }
}