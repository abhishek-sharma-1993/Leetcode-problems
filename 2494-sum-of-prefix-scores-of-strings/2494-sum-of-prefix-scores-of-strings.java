class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            insert(root, word);
        }

        int[] ans = new int[words.length];
        for(int i=0; i<words.length; i++){
            ans[i] = count(root,words[i]);
        }
        return ans;
    }

    private void insert(TrieNode root, String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.child[c-'a'] == null){
                node.child[c-'a'] = new TrieNode();
            }
            node.child[c-'a'].count++;
            node = node.child[c-'a'];
        }
    }

    private int count(TrieNode root, String s){
        TrieNode node = root;
        int ans = 0;
        for(char c : s.toCharArray()){
            ans += node.child[c-'a'].count;
            node = node.child[c-'a'];
        }
        return ans;
    }
}

class TrieNode{
    TrieNode[] child = new TrieNode[26];
    int count=0;
}