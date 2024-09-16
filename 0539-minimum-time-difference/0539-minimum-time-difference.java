class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        int[] mins = new int[timePoints.size()];

        for(int i=0; i<mins.length; i++){
            String[] currArr = timePoints.get(i).split(":");
            int hour_curr = Integer.parseInt(currArr[0]);
            int min_curr = Integer.parseInt(currArr[1]);
            int curr_mins = hour_curr*60+min_curr;
            mins[i] = curr_mins;
        }

        Arrays.sort(mins);
        int prev = mins[0];
        for(int i=1; i<mins.length; i++){
            ans = Math.min(ans, mins[i]-prev);
            prev = mins[i];
        }
        ans = Math.min(ans, 24*60-mins[mins.length-1]+mins[0]);
        return ans;
    }
}
