class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
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