class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        Task[] arr = new Task[n];
        for(int i=0; i<n; i++){
            arr[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(arr, (a,b) -> a.startTime - b.startTime);

        Queue<Task> heap = new PriorityQueue<>((a,b) -> {
            if(a.processingTime == b.processingTime) return a.index-b.index;
            else return a.processingTime - b.processingTime;
        });
        
        int[] ans = new int[n];
        int time = 0;
        int currIdx = 0;
        int ansIdx = 0;
        while(ansIdx < n){
            while(currIdx < n && time >= arr[currIdx].startTime){
                heap.add(arr[currIdx++]);
            }

            if(!heap.isEmpty()){
                Task task = heap.poll();
                ans[ansIdx++] = task.index;
                time += task.processingTime;
            }else{
                time = arr[currIdx].startTime;
            }
        }
        return ans;

    }
}

class Task{
    int startTime;
    int processingTime;
    int index;
    Task(int startTime, int processingTime, int index){
        this.startTime = startTime;
        this.processingTime = processingTime;
        this.index = index;
    }
}