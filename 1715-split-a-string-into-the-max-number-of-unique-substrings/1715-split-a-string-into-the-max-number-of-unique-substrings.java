class Solution {
    int n;
    String s;
    int ans;
    public int maxUniqueSplit(String s) {
        this.n = s.length();
        this.s = s;
        this.ans = 1;
        helper(0, new HashSet<>());
        return ans;
    }

    private void helper(int idx, Set<String> substring){
        if(idx == n) {
            ans = Math.max(ans, substring.size());
            return;
        }

        if((substring.size() + (n-idx)) <= ans) return;

        for(int i=1; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int start = idx, count = i;
            while(count>0 && start<n){
                sb.append(s.charAt(start++));
                count--;
            }
            if(!substring.contains(sb.toString())){
                substring.add(sb.toString());
                helper(idx+i, substring);
                substring.remove(sb.toString());
            }
        }
    }
}