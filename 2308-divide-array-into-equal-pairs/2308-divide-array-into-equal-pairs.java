class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for(int num: nums){
            freq[num]++;
        }

        int pairs = 0;
        for(int i=1; i<freq.length; i++){
            pairs += freq[i]/2;
        }

        return pairs == nums.length/2;
    }
}