class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        int i=0;
        while(n>0){
            ans += 4 * i;
            n--;
            i++;
        }
        return ans;
    }
}

// 1 5 13 25
//. 4 8  12