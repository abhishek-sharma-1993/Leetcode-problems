class Solution {
    public int minimumDeletions(String s) {
        int numDeletion = 0;
        char[] charArr = s.toCharArray();
        int countB = 0;
        for(char ch: charArr){
            numDeletion += 'b'- ch;
            if(numDeletion>countB)
                numDeletion = countB;
            countB += ch - 'a';
        }

        return numDeletion;
    }
}