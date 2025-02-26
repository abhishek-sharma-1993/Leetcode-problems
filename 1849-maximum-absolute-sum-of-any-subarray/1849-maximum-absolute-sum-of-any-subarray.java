class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, maxSum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        int minSum = 0;
        sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            minSum = Math.min(minSum, sum);
            if(sum>0){
                sum=0;
            }
        }
        minSum *= -1;
        return Math.max(minSum,maxSum);
    }
}