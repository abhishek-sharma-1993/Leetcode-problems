class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n2<n1) return false;

        int[] freq1 = new int[26];
        for(char ch : s1.toCharArray())
            freq1[ch-'a']++;

        int[] freq2 = new int[26];
        for(int i=0; i<n1; i++){
            char ch = s2.charAt(i);
            freq2[ch-'a']++;
        }
        if(compare(freq1, freq2)) return true;

        int l=1,r=n1;
        while(r<n2){
            freq2[s2.charAt(l-1)-'a']--;
            freq2[s2.charAt(r)-'a']++;
            if(compare(freq1, freq2)) return true;
            l++;r++;
        }


        return false;
    }

    private boolean compare(int[] freq1, int[] freq2){
        for(int i=0; i<26; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}