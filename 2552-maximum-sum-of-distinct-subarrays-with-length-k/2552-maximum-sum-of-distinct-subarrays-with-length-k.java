class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        Map<Integer, Integer> map =new HashMap<>();

        for(int i=0; i<k; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        if(map.size() == k) ans = Math.max(ans, sum);

        int start = 1, end = k;
        while(end<nums.length){
            sum -= nums[start-1];
            sum += nums[end];

            if(map.containsKey(nums[start-1])){
                int count = map.get(nums[start-1]);
                if(count == 1) 
                    map.remove(nums[start-1]);
                else 
                    map.put(nums[start-1],--count);
            }

            map.put(nums[end], map.getOrDefault(nums[end],0)+1);

            if(map.size() == k) 
                ans = Math.max(ans, sum);
            
            start++;
            end++;
        }
        return ans;
    }
}