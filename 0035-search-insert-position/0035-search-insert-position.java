class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]==target) return i;
            if(nums[i]>target) ans = i;
        }
        return ans;
    }
}