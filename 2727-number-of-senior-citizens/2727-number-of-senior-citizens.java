class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;

        for(String value: details){
            int age = Integer.parseInt(String.valueOf(value.charAt(11))) *10 
            + Integer.parseInt(String.valueOf(value.charAt(12)));

            if(age>60) ans++;
        }
        return ans;
    }
}