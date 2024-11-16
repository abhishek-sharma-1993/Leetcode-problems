class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        int nonConsecutive = 0;
        for(int i=1; i<k; i++){
            if(nums[i]!=nums[i-1]+1) 
                nonConsecutive++;
        }
        int left=0,right=k-1;
        int i=0;
        while(right<n){
            ans[i++] = nonConsecutive == 0 ? nums[right] : -1;

            if(left<n-1 && nums[left+1] != nums[left]+1){
                nonConsecutive--;
            }

            if(right<n-1 && nums[right+1] != nums[right]+1){
                nonConsecutive++;
            }

            left++;
            right++;
        }
        return ans;
    }
}