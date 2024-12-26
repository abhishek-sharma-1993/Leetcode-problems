public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * totalSum + 1];

        // Initialize the first row of the DP table
        dp[0][nums[0] + totalSum] = 1;
        dp[0][-nums[0] + totalSum] += 1;

        // Fill the DP table
        for (int index = 1; index < nums.length; index++) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[index - 1][sum + totalSum] > 0) {
                    dp[index][sum + nums[index] + totalSum] += dp[index -
                        1][sum + totalSum];
                    dp[index][sum - nums[index] + totalSum] += dp[index -
                        1][sum + totalSum];
                }
            }
        }

        // Return the result if the target is within the valid range
        return Math.abs(target) > totalSum
            ? 0
            : dp[nums.length - 1][target + totalSum];
    }
}