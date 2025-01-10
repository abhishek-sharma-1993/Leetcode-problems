class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq1 = new int[26];
        for(String word: words2){
            int[] tmp = new int[26];
            for(char ch : word.toCharArray()){
                tmp[ch-'a']++;
            }
            for(int i=0; i<26; i++){
                freq1[i] = Math.max(freq1[i], tmp[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String word: words1){

            int[] freq2 = new int[26];
            for(char ch : word.toCharArray()){
                freq2[ch-'a']++;
            }

            if(isSubset(freq1, freq2)) ans.add(word);
        }

        return ans;
    }

    private boolean isSubset(int[] freq1, int[] freq2){
        for(int i=0; i<26; i++){
            if(freq1[i]>0 && freq1[i]>freq2[i])
                return false;
        }
        return true;
    }
}