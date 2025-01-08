class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                ans += isPrefixAndSuffix(words[i], words[j]) ? 1:0;
            }
        }
        return ans;
    }

    private boolean isPrefixAndSuffix(String str1, String str2){
        int s1 = 0, s2 = 0;
        while(s1<str1.length()){
            if(s2 >= str2.length() || str1.charAt(s1) != str2.charAt(s2))
                return false;
            
            s1++;s2++;
        }

        int e1 = str1.length()-1, e2 = str2.length()-1;
        while(e1>=0){
            if(e2<0 || str1.charAt(e1) != str2.charAt(e2))
                return false;
            e1--;e2--;
        }

        return true;
    }
}