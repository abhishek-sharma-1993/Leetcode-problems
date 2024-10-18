class Solution {
    int n;
    int[] nums;
    int maxOr;
    int ans;
    public int countMaxOrSubsets(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.maxOr = 0;
        this.ans = 0;
        for(int num: nums) maxOr |= num;

        findSubset(0, 0);

        return (int)ans;
    }

    private void findSubset(int index, int currOr){
        if(index == n) {
            if(currOr == maxOr) ans++;
            return;
        }
        findSubset(index+1, currOr | nums[index]);
        findSubset(index+1, currOr);
    }
}