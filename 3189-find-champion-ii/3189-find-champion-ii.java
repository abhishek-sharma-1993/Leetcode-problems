class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for(int[] edge: edges){
            inDegree[edge[1]]++;
        }
        int zeros = 0, ans = -1;
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                zeros++;
                ans = i;
            }
        }

        if(zeros == 1) return ans;
        return -1;
    }
}