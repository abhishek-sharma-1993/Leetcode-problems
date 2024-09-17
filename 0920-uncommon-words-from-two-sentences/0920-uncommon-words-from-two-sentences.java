class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] sen1 = s1.split(" ");
        String[] sen2 = s2.split(" ");

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(String word : sen1){
            map1.put(word, map1.getOrDefault(word,0)+1);
        }

        for(String word : sen2){
            map2.put(word, map2.getOrDefault(word,0)+1);
        }
        List<String> ans = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : map1.entrySet()){
            String word = entry.getKey();
            if(entry.getValue() == 1 
                && !map2.containsKey(word)
            ){
                ans.add(word);
            }
        }

        for(Map.Entry<String,Integer> entry : map2.entrySet()){
            String word = entry.getKey();
            if(entry.getValue() == 1 
                && !map1.containsKey(word)
            ){
                ans.add(word);
            }
        }

        String[] words = new String[ans.size()];
        for(int i=0; i<words.length; i++){
            words[i] = ans.get(i);
        }

        return words;
    }
}