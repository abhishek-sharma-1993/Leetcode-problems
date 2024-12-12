class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift: gifts){
            heap.add(gift);
        }

        for(int i=0; i<k; i++){
            int gift = heap.remove();
            int rem = (int) Math.floor(Math.sqrt(gift));
            heap.add(rem);
        }
        long ans=0;
        while(!heap.isEmpty()){
            ans += heap.remove()*1l;
        }
        return ans;
    }
}