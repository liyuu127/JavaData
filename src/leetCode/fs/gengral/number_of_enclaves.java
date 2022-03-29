package leetCode.fs.gengral;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 飞地的数量
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * <p>
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * <p>
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class number_of_enclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] v = new boolean[m][n];
        int sum = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                v[i][0] = true;
                queue.add(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                v[i][n - 1] = true;
                queue.add(new int[]{i, n - 1});
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (grid[0][i] == 1) {
                v[0][i] = true;
                queue.add(new int[]{0, i});
            }
            if (grid[m - 1][i] == 1) {
                v[m - 1][i] = true;
                queue.add(new int[]{m - 1, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0], currCol = cell[1];
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1 && !v[nextRow][nextCol]) {
                    v[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }

        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !v[i][j]) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
