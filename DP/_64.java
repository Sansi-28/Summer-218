package DP;
import java.util.*;
public class _64 {
        private int[][] memo;

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            memo = new int[m][n];


            for (int i = 0; i < m; i++) {
                Arrays.fill(memo[i], -1);
            }

            return helper(grid, 0, 0);
        }

        private int helper(int[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;


            if (row == m - 1 && col == n - 1) {
                return grid[row][col];
            }


            if (row >= m || col >= n) {
                return Integer.MAX_VALUE;
            }


            if (memo[row][col] != -1) {
                return memo[row][col];
            }


            int right = helper(grid, row, col + 1);
            int down = helper(grid, row + 1, col);


            memo[row][col] = grid[row][col] + Math.min(right, down);
            return memo[row][col];
        }

}
class Test_64{
    public static void main(String[] args) {
        _64 solution = new _64();
//        Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
        int [][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(grid));
    }
}
