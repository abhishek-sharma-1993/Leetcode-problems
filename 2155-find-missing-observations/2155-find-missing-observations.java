class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int m = rolls.length;
        for(int num: rolls)
            sum += num;
        
        int missingSum = mean * (n+m) - sum;

        if(missingSum > 6*n || missingSum < n) return new int[]{};

        int fill = missingSum/n;
        int[] ans = new int[n];
        Arrays.fill(ans,fill);
        int mod = missingSum % n;
        for(int i=0; i<mod; i++){
            ans[i]++;
        }

        return ans;  
    }
}