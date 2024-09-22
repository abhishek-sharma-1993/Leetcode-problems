class Solution {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        int i = 1;
        while(i<k){
            long steps = count(cur,n);
            if(i+steps <= k){
                cur++;
                i += steps;
            }else{
                cur *= 10;
                i += 1;
            }
        }
        return (int) cur;
    }

    private long count(long cur, int n){
        long res = 0;
        long nei = cur+1;
        while(cur<=n){
            res += Math.min(nei, n+1) - cur;
            nei *= 10;
            cur *= 10;
        }
        return res;
    }
}