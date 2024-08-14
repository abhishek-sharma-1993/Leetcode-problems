class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums[nums.length-1]-nums[0];
        
        while(l<r){
            int mid = l + (r-l)/2;

            int rank = fingRankOfDiff(nums, mid);
            if(rank<k){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return l;
    }

    private int fingRankOfDiff(int[] nums, int diff){
        int rank = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int pairDiff = Math.abs(nums[i]-nums[j]);
                if(pairDiff<=diff)
                    rank++;
            }
        }
        return rank;
    }
}