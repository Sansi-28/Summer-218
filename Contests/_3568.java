package Contests;
import java.util.*;
public class _3568 {


        static class State {
            int r, c, energy, mask;
            State(int r, int c, int energy, int mask) {
                this.r = r;
                this.c = c;
                this.energy = energy;
                this.mask = mask;
            }
        }

        public int minMoves(String[] classroom, int maxEnergy) {
            int m = classroom.length, n = classroom[0].length();
            char[][] grid = new char[m][n];
            for (int i = 0; i < m; i++) grid[i] = classroom[i].toCharArray();

            int startR = -1, startC = -1;
            List<int[]> litter = new ArrayList<>();

            // Find start and litter cells
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'S') {
                        startR = i;
                        startC = j;
                    } else if (grid[i][j] == 'L') {
                        litter.add(new int[]{i, j});
                    }
                }
            }

            int litterCount = litter.size();
            int allCollectedMask = (1 << litterCount) - 1;

            // Map from position to litter index
            int[][] litterIndex = new int[m][n];
            for (int[] row : litterIndex) Arrays.fill(row, -1);
            for (int i = 0; i < litterCount; i++) {
                int[] pos = litter.get(i);
                litterIndex[pos[0]][pos[1]] = i;
            }

            // visited[r][c][energy][mask]
            boolean[][][][] visited = new boolean[m][n][maxEnergy + 1][1 << litterCount];
            Queue<State> queue = new LinkedList<>();
            queue.offer(new State(startR, startC, maxEnergy, 0));
            visited[startR][startC][maxEnergy][0] = true;

            int moves = 0;
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    State cur = queue.poll();

                    // Check if all litter collected
                    if (cur.mask == allCollectedMask) return moves;

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = cur.r + dr[dir];
                        int nc = cur.c + dc[dir];

                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                        char cell = grid[nr][nc];
                        if (cell == 'X') continue; // obstacle

                        int newEnergy = cur.energy - 1;

                        // If energy is 0, can only move if current cell is R to reset
                        if (newEnergy < 0) {
                            // Only if current position is R, reset energy before moving
                            if (grid[cur.r][cur.c] == 'R') {
                                newEnergy = maxEnergy - 1; // reset then move
                            } else {
                                continue; // no energy to move
                            }
                        }

                        // If next cell is R, reset energy after moving
                        if (cell == 'R') {
                            newEnergy = maxEnergy;
                        }

                        int newMask = cur.mask;
                        if (litterIndex[nr][nc] != -1) {
                            newMask = newMask | (1 << litterIndex[nr][nc]);
                        }

                        if (!visited[nr][nc][newEnergy][newMask]) {
                            visited[nr][nc][newEnergy][newMask] = true;
                            queue.offer(new State(nr, nc, newEnergy, newMask));
                        }
                    }
                }
                moves++;
            }

            return -1; // not possible
        }
}

class Test_3568{
    public static void main(String[] args) {
        _3568 solution = new _3568();
//        Input: classroom = ["S.", "XL"], energy = 2
        String[] classroom = {"S.", "XL"};
        int energy = 2;
        System.out.println(solution.minMoves(classroom, energy));
    }
}
