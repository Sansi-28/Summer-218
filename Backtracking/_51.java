package Backtracking;
import java.util.*;
class Test_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with dots
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(0, board, result, n);
        return result;
    }

    private void solve(int row, char[][] board, List<List<String>> result, int n) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(row + 1, board, result, n);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check top-left diagonal
        for (int i = row - 1, j = col - 1; i >=0 && j >=0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check top-right diagonal
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}
public class _51 {
        public static void main(String[] args) {
            Test_51 solution = new Test_51();

            int n = 4; // Example test case
            List<List<String>> results = solution.solveNQueens(n);

            System.out.println("Total solutions: " + results.size());
            for (List<String> board : results) {
                for (String row : board) {
                    System.out.println(row);
                }
                System.out.println(); // Separate boards
            }
        }
    }
