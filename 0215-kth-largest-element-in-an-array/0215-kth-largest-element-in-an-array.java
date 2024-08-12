class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums)
            heap.add(num);

        while(k>1){
            heap.poll();
            k--;
        }
            
        
        return heap.peek();
    }
}