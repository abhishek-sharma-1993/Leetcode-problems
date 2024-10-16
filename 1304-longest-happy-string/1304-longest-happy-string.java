class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int n = a+b+c;
        int[][] abc = {{0,a},{1,b},{2,c}};
        Queue<int[]> heap = new PriorityQueue<>((x,y)->y[1]-x[1]);

        if(abc[0][1]>0) heap.add(abc[0]);
        if(abc[1][1]>0) heap.add(abc[1]);
        if(abc[2][1]>0) heap.add(abc[2]);

        StringBuilder ans = new StringBuilder();
        while(!heap.isEmpty()){
            int[] pair = heap.remove();
            char ch = (char) ((char) pair[0] + 'a') ;

            if(ans.length()>=2 
                && ans.charAt(ans.length()-1) == ch
                && ans.charAt(ans.length()-2) == ch
            ){
                if(heap.isEmpty()) break;

                int[] next = heap.remove();
                ans.append((char) ((char) next[0] + 'a'));
                if(--next[1] > 0) heap.add(next);

            }else{
                ans.append(ch);
                pair[1]--;
            }

            if(pair[1]>0) heap.add(pair);
        }

        return ans.toString();
    }
}