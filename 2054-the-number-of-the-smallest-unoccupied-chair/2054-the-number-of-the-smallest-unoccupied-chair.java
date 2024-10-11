class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        Queue<int[]> heapArr = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Queue<int[]> heapDep = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Queue<Integer> availableChair = new PriorityQueue<>();

        for(int i=0; i<times.length; i++){
            heapArr.add(new int[]{i, times[i][0]});
            heapDep.add(new int[]{i, times[i][1]});
            availableChair.add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        while(!heapArr.isEmpty() && !heapDep.isEmpty()){

            if(heapArr.peek()[1] < heapDep.peek()[1]){
                int[] pair = heapArr.remove();
                int friend = pair[0];
                int arrivalTime = pair[1];

                map.put(friend, availableChair.remove());
            }else{
                int[] derPair = heapDep.remove();
                int fre = derPair[0];
                int depTime = derPair[1];

                int chair = map.get(fre);
                availableChair.add(chair);
            }
        }
        return map.get(targetFriend);
    }
}