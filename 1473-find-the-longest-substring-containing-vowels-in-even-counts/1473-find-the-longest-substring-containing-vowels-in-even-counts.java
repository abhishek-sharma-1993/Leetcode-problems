class Solution {

    private static final int[] characterMap = new int[26];
    static{
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
    }
        
    public int findTheLongestSubstring(String s) {
        int[] map = new int[32];
        Arrays.fill(map,-1);
        int ans = 0, bitmask = 0;

        for(int i=0; i<s.length(); i++){
            bitmask ^= characterMap[s.charAt(i)-'a'];

            if(map[bitmask] == -1 && bitmask != 0)
                map[bitmask] = i;
            else
                ans = Math.max(ans, i-map[bitmask]);
        }
        return ans;
    }
}