class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int ans = 0;
        for(int i=0; i<26; i++){
            if(freq[i]==0) continue;
            ans += (freq[i]&1)==0?2:1;
        }
        return ans;
    }
}