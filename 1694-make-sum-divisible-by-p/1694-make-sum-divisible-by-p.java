class Solution {
    public int minSubarray(int[] nums, int p) {
        int ans = nums.length;
        long totalSum = 0;

        for(int num: nums) 
            totalSum = (totalSum+num)%p;

        int target = (int) totalSum % p;

        if(target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int currentSum = 0;
        for(int i=0; i<nums.length; i++){
            currentSum = (currentSum + nums[i]) % p;

            int needed = (currentSum - target + p)%p;
            if(map.containsKey(needed))
                ans = Math.min(ans, i-map.get(needed));

            map.put(currentSum,i);
        }
        return ans==nums.length ? -1 : ans;
    }
}