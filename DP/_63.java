package DP;
import java.util.*;
public class _63 {
        int [][] memo;

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            memo = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(memo[i], -1);
            }

            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }

            helper(obstacleGrid, 0, 0);
            return memo[0][0];
        }

        private int helper(int[][] grid, int row, int col ) {
            int m = grid.length;
            int n = grid[0].length;
            if (row >= m || col >= n || grid[row][col] == 1) {
                return 0;
            }

            if (row == m - 1 && col == n - 1) {
                memo[row][col] = 1;
                return 1;
            }

            if (memo[row][col] != -1) {
                return memo[row][col];
            }

            int down = helper(grid, row + 1, col);
            int right = helper(grid, row, col + 1);

            memo[row][col] = down + right;
            return memo[row][col];
        }
}

class Test_63{
    public static void main(String[] args) {
        _63 solution = new _63();
//        Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//        Output: 2
        int [][] obstacleGrid = {{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
