class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);
    
        for(int i=1; i<arrays.size(); i++){
                int N = arrays.get(i).size();
                int first = arrays.get(i).get(0);
                int last = arrays.get(i).get(N-1);

                ans = Math.max(ans, Math.max(Math.abs(last - min), Math.abs(max - first)));
                if(min>first) min = first;
                if(max<last) max = last;
        }

        return ans;
    }
}