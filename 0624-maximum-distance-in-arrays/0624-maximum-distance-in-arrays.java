class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);
    
        for(int i=1; i<arrays.size(); i++){
                int N = arrays.get(i).size();

                int diff1 = Math.abs(arrays.get(i).get(N-1) - min); 
                int diff2 = Math.abs(max - arrays.get(i).get(0)); 

                min = Math.min(min, arrays.get(i).get(0));
                max = Math.max(max, arrays.get(i).get(N-1));

                ans = Math.max(ans, Math.max(diff1, diff2));
        }

        return ans;
    }
}