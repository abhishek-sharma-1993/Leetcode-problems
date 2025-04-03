class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = nums[0];
        suffixMax[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(nums[i], prefixMax[i-1]);
            suffixMax[n-i-1] = Math.max(nums[n-i-1], suffixMax[n-i]);
        }
        long ans = 0;
        for(int j=1; j<n-1; j++){
            long value = ((prefixMax[j-1]*1l - nums[j]*1l) * suffixMax[j+1]) * 1l;
            ans = Math.max(ans, value);
        }
        return ans;
    }
}

/*
n = 5
i      0   1.  2   3    4
arr = [12, 6,  1,  2,   7]
pmax =[12, 12, 12, 12, 12]
smax =[12 , 7,  7,  7,  7]

j=1 to N-1

ans = 
*/