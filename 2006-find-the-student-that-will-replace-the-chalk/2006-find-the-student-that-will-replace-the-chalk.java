class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n=chalk.length;
        long[] prefix = new long[n];
        prefix[0] = chalk[0];

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1]+chalk[i];
        }
        int ans = 0;
        int l=0,r=k;
        while(l<=r){
            int mid = l + (r-l)/2;
            int times = mid/n;
            int index = mid%n;

            long currentChalk = prefix[n-1]*times + prefix[index];
            if(k-currentChalk < 0){
                ans = index;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}