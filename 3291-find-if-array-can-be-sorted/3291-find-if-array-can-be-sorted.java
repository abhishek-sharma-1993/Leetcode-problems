class Solution {
    public boolean canSortArray(int[] nums) {
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            int cnt = 0;
            for(int bit=0; bit<32; bit++){
                if( ((1<<bit) & num) > 0){
                    cnt++;
                }
            }
            map.put(num, cnt);
        }

        for(int i=1; i<n; i++){
            int j=i;
            while(j>0){
                if(map.get(nums[j]) == map.get(nums[j-1]) 
                    && nums[j]<nums[j-1]){
                        int tmp = nums[j-1];
                        nums[j-1] = nums[j];
                        nums[j] = tmp;
                    }
                j--;
            }
        }
        
        for(int i=0;i<n; i++){
            if(sorted[i] != nums[i])
                return false;
        }
        
        return true;
    }
}