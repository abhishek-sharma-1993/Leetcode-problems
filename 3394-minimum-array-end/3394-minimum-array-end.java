class Solution {
    public long minEnd(int n, int x) {
        long ans = (x);
        for(int i=1; i<n; i++){
            long next = ans+1;
            next = next | x;
            ans = next;
        }
        return ans;
    }
}
