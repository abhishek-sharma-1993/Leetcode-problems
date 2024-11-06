class Solution {
    public boolean canSortArray(int[] nums) {
        int[] sorted = Arrays.stream(nums).sorted().toArray();

        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i-1]<=nums[i]) continue;
            int j=i;
            while(j>0){
                if(nums[j]>nums[j-1]) {
                    j--;
                    continue;
                }
                else if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j-1])){
                        int tmp = nums[j-1];
                        nums[j-1] = nums[j];
                        nums[j] = tmp;
                        j--;
                }else{
                    return false;
                }
            }
        }
        
        for(int i=0;i<n; i++){
            if(sorted[i] != nums[i])
                return false;
        }

        return true;
    }
}