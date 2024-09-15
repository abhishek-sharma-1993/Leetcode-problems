class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = 0, bitmask = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case 'a' : bitmask ^= (1<<0);break;
                case 'e' : bitmask ^= (1<<1);break;
                case 'i' : bitmask ^= (1<<2);break;
                case 'o' : bitmask ^= (1<<3);break;
                case 'u' : bitmask ^= (1<<4);break;
            }

            if(map.containsKey(bitmask))
                ans = Math.max(ans, i-map.get(bitmask));
            else
                map.put(bitmask,i);
        }
        return ans;
    }
}