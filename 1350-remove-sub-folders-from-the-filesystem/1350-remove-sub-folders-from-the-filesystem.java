class Solution {
    public List<String> removeSubfolders(String[] folder) {
       TrieNode root = new TrieNode();

       for(String str : folder){
            TrieNode currNode = root;
            String[] names = str.split("/");

            for(String name: names){
                if(name.isEmpty()) continue;

                if(!currNode.child.containsKey(name)){
                    currNode.child.put(name, new TrieNode());
                }
                currNode = currNode.child.get(name);
            }
            currNode.isEnd = true;
       }

        List<String> ans = new ArrayList<>();
        for(String str: folder){
            TrieNode currNode = root;
            String[] names = str.split("/");

            boolean isSubFolder = false;
            for(int i=0; i<names.length; i++){
                if(names[i].isEmpty()) continue;

                TrieNode nextNode = currNode.child.get(names[i]);

                if(nextNode.isEnd && i != names.length-1){
                    isSubFolder = true;
                    break;
                }
                currNode = nextNode;
            }

            if(!isSubFolder) ans.add(str);
        }

        return ans;
    }
}

class TrieNode{
    boolean isEnd;
    Map<String, TrieNode> child;

    TrieNode(){
        isEnd = false;
        child = new HashMap<>();
    }
}