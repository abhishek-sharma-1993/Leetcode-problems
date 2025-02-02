class Solution {
    public boolean check(int[] nums) {
        int max=0, min=101;
        for(int num: nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int prev = nums[0];
        boolean isRotated = false;
        for(int i=1; i<nums.length; i++){
            if(prev>nums[i]){
                if(prev != max || nums[i] != min) 
                    return false;
                else
                    isRotated = true;
            }
            prev = nums[i];
        }

        if(prev>nums[0] && isRotated) return false;

        return true;
    }
}