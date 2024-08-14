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
        int rank = 0, j = 0;
        for(int i=0; i<nums.length; i++){
            while(nums[i]-nums[j]>diff)
                j++;
            
            rank += i-j;
        }
        return rank;
    }
}