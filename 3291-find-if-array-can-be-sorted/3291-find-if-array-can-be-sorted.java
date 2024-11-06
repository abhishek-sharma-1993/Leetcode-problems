class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i-1]<=nums[i]) continue;
            else if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i-1])){
                    int tmp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = tmp;
            }else{
                return false;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i+1]>nums[i]) continue;
            else if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i+1])){
                    int tmp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = tmp;
            }else{
                return false;
            }
        }
        

        return true;
    }
}