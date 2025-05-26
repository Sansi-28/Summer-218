package Graph;
import java.util.*;
public class _909 {

        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            boolean[] visited = new boolean[n * n + 1];
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(1); // start from square 1
            visited[1] = true;
            int moves = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    if (curr == n * n) return moves;

                    for (int dice = 1; dice <= 6; dice++) {
                        int next = curr + dice;
                        if (next > n * n) continue;

                        int[] coords = getCoordinates(next, n);
                        int row = coords[0], col = coords[1];

                        if (board[row][col] != -1) {
                            next = board[row][col];
                        }

                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
                moves++;
            }
            return -1;
        }

        private int[] getCoordinates(int num, int n) {
            int row = (num - 1) / n;
            int col = (num - 1) % n;
            row = n - 1 - row;
            if ((n - row) % 2 == 0) {

                col = n - 1 - col;
            }
            return new int[]{row, col};
        }
}
class Test_909{
    public static void main(String[] args) {
        _909 solution = new _909();
        int [][] board = {  {-1,-1,-1,-1,-1,-1},
                            {-1,-1,-1,-1,-1,-1},
                            {-1,-1,-1,-1,-1,-1},
                            {-1,35,-1,-1,13,-1},
                            {-1,-1,-1,-1,-1,-1},
                            {-1,15,-1,-1,-1,-1}};
        System.out.println(solution.snakesAndLadders(board));
    }
}
