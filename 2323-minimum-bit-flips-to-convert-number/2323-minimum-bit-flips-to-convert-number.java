class Solution {

    /*
        10 - 1010
        7. - 0111
    */
    public int minBitFlips(int start, int goal) {
        int ans = 0;

        for(int bit=0; bit<32; bit++){
            int startBit = (start & (1<<bit)) > 0 ? 1 : 0;
            int goalBit = (goal & (1<<bit)) > 0 ? 1 : 0;

            if(startBit != goalBit){
                ans++;
            }
        }
        return ans;
    }
}