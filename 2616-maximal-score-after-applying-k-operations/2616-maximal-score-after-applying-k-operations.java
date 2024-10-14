class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            heap.add(num);
        }

        long ans = 0;
        while(!heap.isEmpty() && k>0){
            int num = heap.remove();
            ans += num;
            num = (int) Math.ceil(1d*num/3);
            heap.add(num);
            k--;
        }

        return ans;
    }
}