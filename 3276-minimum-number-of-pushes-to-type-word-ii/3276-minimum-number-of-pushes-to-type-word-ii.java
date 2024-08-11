class Solution {
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            freq[ch -'a']++;
        }

        Arrays.sort(freq, (a,b) ->{
            return b-a;
        });

        int counter = 1;
        int ans = 0;
        for(int i=0; i<26; i++){
            ans += counter * freq[i];
            if((i+1)%8 == 0)
                counter++;
        }

        return ans;
    }
}