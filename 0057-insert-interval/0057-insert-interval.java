class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l=newInterval[0];
        int r=newInterval[1];

        List<int[]> ans = new ArrayList<>();

        for(int i=0; i<intervals.length; i++){
            int si = intervals[i][0];
            int ei = intervals[i][1];

            if(l>ei){
                ans.add(new int[]{si,ei});
            }else if(r<si){
                ans.add(new int[]{l,r});
                for(int j=i; j<intervals.length; j++){
                    ans.add(new int[]{intervals[j][0],intervals[j][1]});
                }
                return toArray(ans);
            }else{
                l = Math.min(l,si);
                r = Math.max(r,ei);
            }
        }

        ans.add(new int[]{l,r});
        
        return toArray(ans);
    }

    private int[][] toArray(List<int[]> list){
        int[][] merged = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            merged[i] = list.get(i);
        }
        return merged;
    }
}