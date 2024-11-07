class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for(int bit=0; bit<32; bit++){
            int currSetBits = 0;
            for(int i=0; i<candidates.length; i++){
                if( ((1<<bit) & candidates[i]) > 0 ) currSetBits++;
            }
            ans = Math.max(ans, currSetBits);
        }
        return ans;
    }
}