class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int num: nums){
            int sum = digitSum(num);
            Queue<Integer> pq = map.getOrDefault(sum, new PriorityQueue<>(Collections.reverseOrder()));
            pq.add(num);
            map.put(sum, pq);
        }
        int ans = -1;
        for(Map.Entry<Integer, Queue<Integer>> entry: map.entrySet()){
            Queue<Integer> pq = entry.getValue();
            if(pq.size()>=2){
                int max1 = pq.remove();
                int max2 = pq.remove();

                ans = Math.max(ans, max1+max2);
            }
        }
        return ans;
    }

    private int digitSum(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}