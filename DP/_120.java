package DP;
import java.util.*;
public class _120 {
        private int [][] memo;
        public int minimumTotal(List<List<Integer>> triangle) {
            memo = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
            return helper(triangle, 0, 0 );
        }

        private int helper(List<List<Integer>> triangle, int row, int col){
            if(row == triangle.size()){
                return 0;
            }
            memo[row][col] = triangle.get(row).get(col) + Math.min(helper(triangle, row+1, col), helper(triangle, row + 1, col + 1));
            return memo[row][col];
        }
}

class Test_120{
    public static void main(String[] args) {
        // Example Triangle
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        // Call the solution
        _120 solution = new _120();

        int result = solution.minimumTotal(triangle);

        // Print the result
        System.out.println("Minimum path sum is: " + result);
    }

}
