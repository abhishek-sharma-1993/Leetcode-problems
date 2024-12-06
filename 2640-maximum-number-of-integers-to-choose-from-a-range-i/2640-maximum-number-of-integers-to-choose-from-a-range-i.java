class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<banned.length; i++){
            set.add(banned[i]);
        }

        int ans = 0;
        long sum = 0l;
        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                sum += i*1l;
                if(sum>maxSum) {
                    return ans;
                }
                ans++;
            }
        }
        return ans;
    }
}