class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long prev = prevPalindrom(num);
        long next = nextPalindrom(num);
        if(Math.abs(num-prev)>=Math.abs(next-num))
            return String.valueOf(next);
        
        return String.valueOf(prev);
    }

    private long helper(long num){
        String palin = String.valueOf(num);
        int n = palin.length();
        int l=(n-1)/2, r=n/2;
        char[] seq = palin.toCharArray();
        while(l>=0){
            seq[r++] = seq[l--];
        }
        return Long.parseLong(new String(seq));
    }

    private long nextPalindrom(long num){
        long l=0, r=num;
        long ans = Long.MIN_VALUE;
        while(l<=r){
            long mid = l + (r-l)/2;
            long palin = helper(mid);
            if(palin < num){
                ans = palin;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }

    private long prevPalindrom(long num){
        long l=num, r=Long.MAX_VALUE;
        long ans = 0;
        while(l<=r){
            long mid = l + (r-l)/2;
            long palin = helper(mid);

            if(palin > num){
                ans = palin;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}