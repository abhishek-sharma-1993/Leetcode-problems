class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // if(nums.length == 1) return new boolean[]{true};

        int[] ps = new int[nums.length];
        ps[0] = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]%2 == nums[i-1]%2){
                ps[i] = ps[i-1]+1;
            }else{
                ps[i] = ps[i-1];
            }
        }

        boolean[] ans = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];

            ans[i] = ps[e]-ps[s] == 0;
        }

        return ans;
    }
}