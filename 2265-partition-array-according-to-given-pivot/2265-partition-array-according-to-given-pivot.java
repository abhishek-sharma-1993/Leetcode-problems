class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> bigger = new ArrayList<>();
        int equalCount = 0;
        for(int num: nums){
            if(num<pivot) smaller.add(num);
            else if(num>pivot) bigger.add(num);
            else equalCount++;
        }

        int[] ans = new int[nums.length];
        int i=0;
        for(int num: smaller){
            ans[i++] = num;
        }
        while(equalCount>0){
            ans[i++] = pivot;
            equalCount--;
        }
        for(int num: bigger){
            ans[i++] = num;
        }

        return ans;
    }
}