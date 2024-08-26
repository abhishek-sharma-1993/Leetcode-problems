class Solution {
    int[] mapping;
    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.mapping = mapping;
        List<int[]> mappedNums = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int tmp = nums[i] == 0 ? mapping[0] : getValue(nums[i]);
            mappedNums.add(new int[]{tmp, i});
        }

        Collections.sort(mappedNums, (a,b)-> a[0]-b[0] );

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = nums[mappedNums.get(i)[1]];
        }
        return ans;
    }

    private int getValue(int num){
        int ans = 0, pow = 0;
        while(num>0){
            int idx = num%10;
            ans = (int) (mapping[idx])* (int) Math.pow(10,pow) + ans;
            num = num/10;
            pow++;
        }
        return ans;
    }
}