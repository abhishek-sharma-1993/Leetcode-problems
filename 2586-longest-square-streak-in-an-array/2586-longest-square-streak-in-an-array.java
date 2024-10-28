class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for(int num: nums){
            set.add(num*1L);
        }

        int ans = -1;
        for(int num: nums){
            int currStreak = 1;
            long square = (long) num*num;

            while(set.contains(square)) {
                currStreak++;
                square = square*square*1L; 
            }
            if(currStreak == 1) currStreak = -1;
            ans = Math.max(ans, currStreak);
        }
        return ans;
    }
}