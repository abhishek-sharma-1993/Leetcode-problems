class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> heap = new PriorityQueue<>();
        for(int num: nums){
            heap.add(num*1l);
        }
        int ans = 0;

        while(heap.peek()<k){
            long min = heap.poll();
            long max = heap.poll();

            long newNum = min*2*1l + max*1l;
            heap.offer(newNum);
            ans++;
        }

        return ans;
    }
}