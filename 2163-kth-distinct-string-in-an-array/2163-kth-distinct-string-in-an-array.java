class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for(String str: arr){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        int unique = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1) {
                unique++;
                if(unique == k) return entry.getKey();
                
            }

            
        }

        return "";
    }
}