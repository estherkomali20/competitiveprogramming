import java.io.*;
import java.util.*;

public class Solution {

    static class Cell {
        int row, col, time;

        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        Queue<Cell> queue = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 2) {
                    queue.offer(new Cell(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int time = 0;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            time = Math.max(time, current.time);

            for (int k = 0; k < 4; k++) {
                int nr = current.row + dr[k];
                int nc = current.col + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    grid[nr][nc] == 1) {

                    grid[nr][nc] = 2;
                    fresh--;

                    queue.offer(new Cell(nr, nc, current.time + 1));
                }
            }
        }

        if (fresh > 0) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }

        sc.close();
    }
}
