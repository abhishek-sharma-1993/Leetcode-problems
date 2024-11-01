class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        char[] chars = s.toCharArray();
        char prev = chars[0];

        for(char curr: chars){
            if(curr == prev){
                count++;
            }else{
                count = 1;
            }

            if(count < 3){
                ans.append(String.valueOf(curr));
            }
            prev = curr;
        }
        return ans.toString();
    }
}