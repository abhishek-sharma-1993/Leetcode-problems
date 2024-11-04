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
                ans.append(length).append(prev);
                // ans.append(prev);
                length = 1;
            }

            if(length > 9){
                ans.append("9").append(prev);
                // ans.append(prev);
                length = 1;
            }

            if(i==word.length()-1){
                ans.append(length).append(currChar);
                // ans.append(currChar);
            }
            prev = currChar;
        }

        return ans.toString();
    }
}