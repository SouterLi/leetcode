package leetcode.intermediate;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] dp = new int[maxVal + 1];
        for (int num : nums) {
            dp[num] += num;
        }
        int first = dp[0];
        int second = Math.max(dp[0], dp[1]);
        for(int i = 2; i < dp.length; i++) {
            int current = Math.max(second, first + dp[i]);
            first = second;
            second = current;
        }
        return second;
    }

}
