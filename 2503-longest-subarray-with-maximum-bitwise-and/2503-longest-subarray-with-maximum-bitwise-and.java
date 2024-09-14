class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, maxVal = 0, currStreak = 0;

        for(int num :nums){
            if(maxVal<num){
                maxVal = num;
                ans = currStreak = 0;
            }

            if(maxVal == num){
                currStreak++;
            } else {
                currStreak=0;
            }

            ans = Math.max(ans, currStreak);
        }
        return ans;
    }
}