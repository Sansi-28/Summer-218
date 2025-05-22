package DP;
import java.util.*;
public class _322 {
        private int[] mem;

        public int coinChange(int[] coins, int amount) {
            mem = new int[amount + 1];
            Arrays.fill(mem, -1);
            int result = helper(coins, amount);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        public int helper(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return Integer.MAX_VALUE;

            if (mem[amount] != -1) return mem[amount];

            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = helper(coins, amount - coin);
                if (res != Integer.MAX_VALUE) {
                    min = Math.min(min, res + 1);
                }
            }

            mem[amount] = min;
            return min;
        }
}

class Test_322{
    public static void main(String[] args) {
        _322 solution = new _322();
        int n = 11;
        int [] coins = {5, 2, 1};
        System.out.println(solution.coinChange(coins, n));
    }
}
