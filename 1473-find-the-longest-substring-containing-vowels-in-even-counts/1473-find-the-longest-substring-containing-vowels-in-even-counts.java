class Solution {
    public int findTheLongestSubstring(String s) {
        int[] charMap = new int[26];
        charMap['a'-'a'] = 1<<0;
        charMap['e'-'a'] = 1<<1;
        charMap['i'-'a'] = 1<<2;
        charMap['o'-'a'] = 1<<3;
        charMap['u'-'a'] = 1<<4;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = 0, bitmask = 0;

        for(int i=0; i<s.length(); i++){
            bitmask ^= charMap[s.charAt(i)-'a'];

            if(map.containsKey(bitmask))
                ans = Math.max(ans, i-map.get(bitmask));
            else
                map.put(bitmask,i);
        }
        return ans;
    }
}