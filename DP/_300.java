package DP;
import java.util.*;
public class _300 {
        public int lengthOfLIS(int[] nums) {
            int[][] dp = new int[nums.length][nums.length + 1];
            for (int[] row : dp) Arrays.fill(row, -1);
            return helper(nums, 0, -1, dp);
        }

        private int helper(int[] nums, int curr, int prevIndex, int[][] dp) {
            if (curr == nums.length) return 0;

            if (dp[curr][prevIndex + 1] != -1) return dp[curr][prevIndex + 1];

            int notTake = helper(nums, curr + 1, prevIndex, dp);
            int take = 0;
            if (prevIndex == -1 || nums[curr] > nums[prevIndex]) {
                take = 1 + helper(nums, curr + 1, curr, dp);
            }

            return dp[curr][prevIndex + 1] = Math.max(take, notTake);
        }

}

class Test_300{
    public static void main(String[] args) {
//         nums = [10,9,2,5,3,7,101,18] output : 4
        int [] nums = {
                10,9,2,5,3,7,101,18
        };
        _300 solution = new _300();


        System.out.println(solution.lengthOfLIS(nums));
    }
}
