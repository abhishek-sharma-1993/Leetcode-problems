class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            max[i] = Math.max(max[i+1], nums[i]);
        }

        int ans = 0, i=0, j=0;
        while(j<n){
            while(nums[i] > max[j] && i<j) i++;

            ans = Math.max(j-i, ans);
            j++;
        }
        return ans;
    }
}