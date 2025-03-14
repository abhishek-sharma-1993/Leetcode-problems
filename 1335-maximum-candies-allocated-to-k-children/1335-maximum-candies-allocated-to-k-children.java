class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l=0, r=0;
        for(int num : candies){
            r = Math.max(r,num);
        }

        while(l<r){
            int mid = (l + r +1)/2;

            if(allocate(candies, mid, k)){
                l = mid;
            }else{
                r = mid-1;
            }
        }

        return l;
    }

    private boolean allocate(int[] candies, long limit, long k) {
        long maxChilds = 0;
        for(int can : candies){
            maxChilds += can/limit;
        }
        return maxChilds>=k;
    }
}