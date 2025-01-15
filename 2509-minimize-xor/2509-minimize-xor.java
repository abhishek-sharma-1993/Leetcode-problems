class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits = 0;
        for(int bit=0; bit<32; bit++){
            if( (num2 & (1<<bit)) > 0) setBits++;
        }

        int ans = 0;
        for(int bit=31; bit>=0 && setBits>0; bit--){
            if((num1 & (1<<bit)) > 0) {
                ans = ans|(1<<bit);
                setBits--;
            }
        }

        int bit=0;
        while(setBits>0 && bit<32){
            if((ans & (1<<bit)) == 0) {
                ans = ans|(1<<bit);
                setBits--;
            }
            bit++;
        }

        return ans;
    }
}