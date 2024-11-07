class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0, n=candidates.length;
        int mx = Arrays.stream(candidates).max().getAsInt();
        int m = Integer.SIZE - Integer.numberOfLeadingZeros(mx);

        for(int bit=0; bit<m; bit++){
            int currSetBits = 0;
            for(int i=0; i<n; i++){
                currSetBits += (candidates[i]>>bit) & 1;
            }
            if(currSetBits == n) return n;
            ans = Math.max(ans, currSetBits);
        }
        return ans;
    }
}