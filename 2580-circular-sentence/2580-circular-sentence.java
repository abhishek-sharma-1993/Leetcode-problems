class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        String first = words[0];
        String last = words[n-1];

        if(first.charAt(0) != last.charAt(last.length()-1)) return false;

        for(int i=1; i<n; i++){
            if(first.charAt(first.length()-1) != words[i].charAt(0)) return false;

            first = words[i];
        } 
        return true;
    }
}