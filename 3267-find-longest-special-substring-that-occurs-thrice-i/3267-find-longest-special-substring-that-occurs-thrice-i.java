class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> freq = new HashMap<>();
        int len = s.length();
        int ans = -1;

        for(int i=0; i<len; i++){
            char first = s.charAt(i);
            for(int j=i; j<len; j++){
                char last = s.charAt(j);

                if(first != last) break;

                String sub = s.substring(i,j+1);
                freq.put(sub, freq.getOrDefault(sub,0)+1);

                int count = freq.get(sub);
                if(count>=3) 
                    ans = Math.max(ans, sub.length());
            }
        }

        return ans;
    }
}