package Backtracking;
import java.util.*;
public class _52 {
    private int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char [n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        solve(board, 0);

        return count;
    }

    private void solve(char[][] board, int row){
        int n = board.length;
        if(row == n){
            count++;
            return;
        }

        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j )){
                board[row][j] = 'Q';
                solve(board, row+1);
                board[row][j] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        for(int i = 0; i < n; i++ ){
            if(board[row][i] == 'Q') return false;
        }

        for (char[] chars : board) {
            if (chars[col] == 'Q') return false;
        }
        int i = row, j = col;
        while(i < n && j < n){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        i = row; j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = row; j = col;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        i = row; j = col;
        while(i < n && j >= 0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        return true;
    }
}

class Test_52 {
    public static void main(String[] args) {
        _52 solution = new _52();
        int n = 4; // Example test case
        int ans = solution.totalNQueens(n);
        System.out.println("Total solutions: " + ans );
    }
}
