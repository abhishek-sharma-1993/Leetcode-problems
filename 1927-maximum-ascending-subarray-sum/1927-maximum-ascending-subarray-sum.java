class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0], currentSum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                currentSum += nums[i];
            }else{
                currentSum = nums[i];
            }

            ans = Math.max(ans, currentSum);
        }
        return ans;
    }
}