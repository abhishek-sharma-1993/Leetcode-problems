class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 1;
        char[] chars = s.toCharArray();
        char ch = chars[0];
        ans.append(String.valueOf(ch));

        for(int i=1; i<chars.length; i++){
            if(chars[i] == ch){
                count++;
            }else{
                count = 1;
            }

            if(count < 3){
                ans.append(String.valueOf(chars[i]));
            }
            ch = chars[i];
        }
        return ans.toString();
    }
}