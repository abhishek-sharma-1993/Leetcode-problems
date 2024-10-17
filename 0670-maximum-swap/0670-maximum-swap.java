class Solution {
    public int maximumSwap(int num) {
        char[] charNum = String.valueOf(num).toCharArray();
        int n=charNum.length;

        int[] last = new int[10];
        for(int i=0; i<n; i++){
            last[charNum[i]-'0'] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=9; j>charNum[i]-'0'; j--){
                if(last[j]>i){
                    char tmp = charNum[i];
                    charNum[i] = charNum[last[j]];
                    charNum[last[j]] = tmp;
                    return Integer.parseInt(new String(charNum));
                }
            }
        }
        return num;
        
    }
}