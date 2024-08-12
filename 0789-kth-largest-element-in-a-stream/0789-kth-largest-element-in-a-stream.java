class KthLargest {
    int k;
    int[] nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }
    
    public int add(int val) {
        int n = nums.length;
        int[] arr = new int[n+1];
        
        for(int i=0; i<n; i++)
            arr[i] = nums[i];
        arr[n] = val;
        this.nums = arr;

        Arrays.sort(nums);
        return arr[nums.length-k];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);

 2,4,5,8
 2,3,4,5,8 -> 4
 2,3,4,5,5,8 -> 5
 2,3,4,5,5,8,10 -> 5
 2,3,4,5,5,8,9,10 ->8
 2,3,4,4,5,5,8,9,10 ->8
 */