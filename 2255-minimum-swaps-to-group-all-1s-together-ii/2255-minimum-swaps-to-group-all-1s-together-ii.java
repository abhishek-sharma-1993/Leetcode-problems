class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        int N = nums.length;

        for(int i=0; i<N; i++){
            if(nums[i] == 1)
                ones++;
        }

        int swaps = 0;
        for(int i=0; i<ones; i++){
            if(nums[i] == 0) 
                swaps++;
        }

        int start = 1, end = ones;
        int minSwaps = swaps;

        while(end<2*N){
            int s = start;
            int e = end;
            
            if(s>=N) s -= N;
            if(e>=N) e -= N;
            if(s == 0) s=N;

            if(nums[s-1] == 0) 
                swaps--;
            if(nums[e] == 0)
                swaps++;

            minSwaps = Math.min(minSwaps, swaps);

            start++;
            end++;
        }

        return minSwaps;
    }
}
/*
          N-1  N-N N+1-N
0 1 2 3 4 5 6  0   1     9 10 11 12 13
1,1,0,0,0,0,1  1,  1,    0,0, 0, 0, 1



start : 0 1 2 3
end.  : 6 5 4 3
1left : T T T T
1Right: T T T T
0Left : 0 1 1 1
0Right: 0 1 1 1



0,1,0,0,1,0,0

start : 0 1 2 3
end.  : 6 5 4 3
1left : F T T T
1Right: F F T T
0Left : 0 0 1 1
0Right: 0 0 0 0

*/