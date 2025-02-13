class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> heap = new PriorityQueue<>();
        for(int num: nums){
            if(num<k) heap.add(num*1l);
        }
        int ans = 0;

        while(!heap.isEmpty()){
            long min = heap.poll();
            ans++;
            if(heap.isEmpty()) break;

            long max = heap.poll();

            long newNum = min*2l + max;
            if(newNum<k) heap.offer(newNum);   
        }

        return ans;
    }
}