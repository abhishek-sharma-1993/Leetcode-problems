class Solution {
    public int findComplement(int num) {
        boolean firstOne = false;
        for(int bit=31; bit>=0; bit--){
            if( ((num & 1<<bit) > 0) && !firstOne )
                firstOne = true;
            
            if(firstOne)
                num = num^1<<bit;
        }
        return num;
    }
}