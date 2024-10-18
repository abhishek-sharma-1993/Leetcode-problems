class Solution {
    int n;
    int[] nums;
    int maxOr;
    List<Integer> list;
    public int countMaxOrSubsets(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.maxOr = 0;
        this.list = new ArrayList<>();
        findSubset(0, new ArrayList<>());

        long ans = list.stream().filter(n -> n== maxOr).count();
        return (int)ans;
    }

    private void findSubset(int index, List<Integer> subset){
        if(index == n) {
            int OR = 0;
            for(int num: subset){
                OR = OR | num;
            }

            maxOr = Math.max(maxOr, OR);
            list.add(OR);
            return;
        }

        subset.add(nums[index]);
        findSubset(index+1, subset);
        subset.remove(subset.size()-1);
        findSubset(index+1, subset);

    
    }
}