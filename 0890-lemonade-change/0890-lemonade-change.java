class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int num: bills){
            if(num == 20){
                if(ten>=1 && five>=1) {
                    ten--;
                    five--;
                }else if(ten==0 && five>=3){
                    five -= 3;
                }
                else return false;
            }

            if(num == 10){
                if(five>0)
                    five--;
                else
                    return false;
                
                ten++;
            }
            
            if(num == 5) five++;
        }

        return true;
    }
}