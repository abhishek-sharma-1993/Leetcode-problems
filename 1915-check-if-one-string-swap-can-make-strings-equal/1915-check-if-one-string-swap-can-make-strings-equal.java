class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> indexes = new ArrayList<>();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                indexes.add(i);
            }
        }

        int n = indexes.size();
        if(n == 0) return true;
        if(n == 1) return false;
        if(n > 2) return false;

        int s = indexes.get(0), e = indexes.get(1);
        if(s1.charAt(s) != s2.charAt(e)) return false;
        if(s1.charAt(e) != s2.charAt(s)) return false;

        return true;
    }
}