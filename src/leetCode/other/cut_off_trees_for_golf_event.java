package leetCode.other;

import java.util.*;

/**
 * @author liyu
 * date 2022/5/23 9:39
 * description 为高尔夫比赛砍树
 * 你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中：
 * 0 表示障碍，无法触碰
 * 1 表示地面，可以行走
 * 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
 * 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。
 * 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
 * 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
 * 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。
 * 输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
 * 输出：6
 * 解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。
 * 输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
 * 输出：6
 * 解释：可以按与示例 1 相同的路径来砍掉所有的树。
 * (0,0) 位置的树，可以直接砍去，不用算步数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cut-off-trees-for-golf-event
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class cut_off_trees_for_golf_event {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<int[]>();
        int row = forest.size();
        int col = forest.get(0).size();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

        int cx = 0;
        int cy = 0;
        int ans = 0;
        for (int i = 0; i < trees.size(); ++i) {
            int steps = bfs(forest, cx, cy, trees.get(i)[0], trees.get(i)[1]);
            if (steps == -1) {
                return -1;
            }
            ans += steps;
            cx = trees.get(i)[0];
            cy = trees.get(i)[1];
        }
        return ans;

    }
    public int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        if (sx == tx && sy == ty) {
            return 0;
        }

        int row = forest.size();
        int col = forest.get(0).size();
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for (int j = 0; j < 4; ++j) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int bfs_dijkstra(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int row = forest.size();
        int col = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[row][col];
        pq.offer(new int[]{0, sx * col + sy});
        visited[sx][sy] = true;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int dist = arr[0], loc = arr[1];
            for (int j = 0; j < 4; ++j) {
                int nx = loc / col + dirs[j][0];
                int ny = loc % col + dirs[j][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                        if (nx == tx && ny == ty) {
                            return dist + 1;
                        }
                        pq.offer(new int[]{dist + 1, nx * col + ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    public int bfs_a(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int row = forest.size();
        int col = forest.get(0).size();
        int[][] costed = new int[row][col];
        for (int i = 0; i < row; ++i) {
            Arrays.fill(costed[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        costed[sx][sy] = Math.abs(sx - tx) + Math.abs(sy - ty);
        pq.offer(new int[]{costed[sx][sy], 0, sx * col + sy});
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int cost = arr[0], dist = arr[1], loc = arr[2];
            int cx = loc / col;
            int cy = loc % col;
            if (cx == tx && cy == ty) {
                return dist;
            }
            for (int i = 0; i < 4; ++i) {
                int nx = cx + dirs[i][0];
                int ny = cy + dirs[i][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && forest.get(nx).get(ny) > 0) {
                    int ncost = dist + 1 + Math.abs(nx - tx) + Math.abs(ny - ty);
                    if (ncost < costed[nx][ny]) {
                        pq.offer(new int[]{ncost, dist + 1, nx * col + ny});
                        costed[nx][ny] = ncost;
                    }
                }
            }
        }
        return -1;
    }

}
