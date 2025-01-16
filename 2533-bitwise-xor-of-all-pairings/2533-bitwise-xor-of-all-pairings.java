class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if((n&1) == 0 && (m&1) == 0) 
            return 0;

        int nums1Xor = 0;
        for(int num: nums1){
            nums1Xor ^= num;
        }

        int nums2Xor = 0;
        for(int num: nums2){
            nums2Xor ^= num;
        }

        if((n&1)>0 && (m&1) == 0) 
            return nums2Xor;
        if((n&1) == 0 && (m&1)>0) 
            return nums1Xor;

        return nums1Xor^nums2Xor;
    }
}