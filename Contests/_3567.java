package Contests;
import java.util.*;
public class _3567 {
        public int[][] minAbsDiff(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int rows = m - k + 1;
            int cols = n - k + 1;
            int[][] ans = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // collect distinct values in this k×k window
                    Set<Integer> set = new HashSet<>();
                    for (int x = i; x < i + k; x++) {
                        for (int y = j; y < j + k; y++) {
                            set.add(grid[x][y]);
                        }
                    }

                    // if fewer than 2 distinct values, answer is 0
                    if (set.size() < 2) {
                        ans[i][j] = 0;
                        continue;
                    }

                    // sort and scan adjacent differences
                    List<Integer> vals = new ArrayList<>(set);
                    Collections.sort(vals);
                    int minDiff = Integer.MAX_VALUE;
                    for (int t = 1; t < vals.size(); t++) {
                        minDiff = Math.min(minDiff, vals.get(t) - vals.get(t-1));
                        // early exit if zero
                        if (minDiff == 0) break;
                    }
                    ans[i][j] = minDiff;
                }
            }

            return ans;
        }
}

class Test_3567{
    public static void main(String[] args) {
        _3567 solution = new _3567();
//        Input: grid = [[1,8],[3,-2]], k = 2
//
//Output: [[2]]
        int [][] grid = {{1,8},{3,-2}};
        int k = 2;
        int [][] ans = solution.minAbsDiff(grid, k);

        for(int[] e : ans){
            for(int c: e){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
