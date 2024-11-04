class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int length = 0;
        char prev = word.charAt(0);

        for(int i=0; i<word.length(); i++){
            char currChar = word.charAt(i);
            if(currChar == prev ){
                length++;
            }else{
                ans.append(String.valueOf(length));
                ans.append(prev);
                length = 1;
            }

            if(length > 9){
                ans.append("9");
                ans.append(prev);
                length = 1;
            }

            if(i==word.length()-1){
                ans.append(String.valueOf(length));
                ans.append(currChar);
            }
            prev = currChar;
        }

        return ans.toString();
    }
}