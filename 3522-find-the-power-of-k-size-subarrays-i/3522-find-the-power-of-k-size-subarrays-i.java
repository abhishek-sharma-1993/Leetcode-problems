class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int left=0,right=k-1;
        int i=0;
        while(right<n){
            ans[i++] = validate(nums, left, right);
            left++;
            right++;
        }
        return ans;
    }
    private int validate(int[] nums, int i, int j){
        int max = nums[i];
        i++;
        while(i<=j){
            max = Math.max(max, nums[i]);
            if(nums[i-1]>=nums[i] || (nums[i]-nums[i-1]) > 1) return -1;
            i++;
        }
        return max;
    }
}