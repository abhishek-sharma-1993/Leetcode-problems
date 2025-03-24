class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->{
            if(a[0]<b[0]) return -1;
            else if(a[0]>b[0]) return 1;
            else return a[1]-b[1];
        });
        int s=meetings[0][0];
        int e=meetings[0][1];

        int ans = s-1;
        for(int i=1; i<meetings.length; i++){
            int diff = meetings[i][0]-e-1;
            ans += Math.max(0, diff);
            e = Math.max(meetings[i][1],e);
        }
        ans += days-e;

        return ans;
    }
}
/*

[[3,49],[23,44],[21,56],[26,55],[23,52],[2,9],[1,48],[3,31]]

[[1,48],[2,9],[3,31],[3,49],[21,56],[23,44],[23,52],[26,55]]


*/