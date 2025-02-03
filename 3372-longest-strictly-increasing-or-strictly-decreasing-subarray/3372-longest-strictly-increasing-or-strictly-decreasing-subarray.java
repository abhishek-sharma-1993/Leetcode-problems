class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1, incr = 1, decr = 1;
        int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            if(prev<nums[i]){
                incr++;
            }else{
                incr = 1;
            }

            if(prev>nums[i]){
                decr++;
            }else{
                decr = 1;
            }

            
            prev = nums[i];
            ans = Math.max(ans,Math.max(incr,decr));
        }
        return ans;
    }
}