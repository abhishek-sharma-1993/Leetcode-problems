class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int mid = len%2==0 ? len/2-1 : len/2; 
        long firstHalf = Long.parseLong(n.substring(0,mid+1));

        List<Long> possible = new ArrayList<>();
        possible.add(helper(firstHalf, len%2==0));
        possible.add(helper(firstHalf+1, len%2==0));
        possible.add(helper(firstHalf-1, len%2==0));
        possible.add((long) Math.pow(10, len-1)-1); //999
        possible.add((long) Math.pow(10,len)+1); //10001

        long res = 0, num = Long.parseLong(n), diff = Long.MAX_VALUE;
        for(long cand : possible){
            if(cand == num) continue;
            else if(Math.abs(cand-num)<diff){
                diff = Math.abs(cand-num);
                res = cand;
            }else if(Math.abs(cand-num)==diff){
                res = Math.min(res, cand);
            }
        }
        return String.valueOf(res);

    }

    private long helper(long left, boolean even){
        long res = left;
        if(!even) left = left/10;
        while(left>0){
            res = res*10 + (left%10);
            left /= 10;
        }
        return res;
    }
}