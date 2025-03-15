class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = 0;
        for(int num: nums){
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        int ans = 0;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(check(nums, k, mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int k, int limit){
        int houses = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=limit){
                houses++;
                i++;
            }
        }
        return houses>=k;
    }
}