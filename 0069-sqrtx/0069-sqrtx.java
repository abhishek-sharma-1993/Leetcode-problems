class Solution {
    public int mySqrt(int x) {
        if(x==0 || x == 1) return x;
        
        int l=1, r=x/2;
        int ans = 0;
        while(l<=r){
            int mid = l +(r-l)/2;

            if((long) mid*mid == (long) x) {
                return mid;
            }else if((long) mid*mid < (long) x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
            
        }
        return ans;
    }
}