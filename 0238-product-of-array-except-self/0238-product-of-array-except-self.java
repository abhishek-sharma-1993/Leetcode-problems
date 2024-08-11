class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int mul = 1;
        output[0] = 1;
        for(int i=1; i<n; i++){
            mul *= nums[i-1];
            output[i] = mul;
        }
        
        int tmp = 1;
        for(int i=n-2; i>=0; i--){
            tmp *= nums[i+1];
            output[i] = tmp*output[i];
        }
        output[0] = tmp;

        return output;
    }
}