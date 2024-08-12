class KthLargest {
    int k;
    int[] nums;
    Queue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.heap = new PriorityQueue();

        for(int num : nums)
            heap.add(num);

        while(heap.size()>k)
            heap.poll();
    }
    
    public int add(int val) {
        if(k>heap.size())
            heap.add(val);
        else if(val>heap.peek()){
            heap.add(val);
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 k=3
 2,4,5,8
 2,3,4,5,8 -> 4
 2,3,4,5,5,8 -> 5
 2,3,4,5,5,8,10 -> 5
 2,3,4,5,5,8,9,10 ->8
 2,3,4,4,5,5,8,9,10 ->8
 */