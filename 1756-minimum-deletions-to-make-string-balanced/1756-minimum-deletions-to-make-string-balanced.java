class Solution {
    public int minimumDeletions(String s) {
        int numDeletion = 0;
        char[] charArr = s.toCharArray();
        int countB = 0;
        for(char ch: charArr){
            numDeletion += 'b'- ch;
            numDeletion = Math.min(numDeletion, countB);
            countB += ch - 'a';
        }

        return numDeletion;
    }
}