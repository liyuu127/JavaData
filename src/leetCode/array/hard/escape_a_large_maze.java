package leetCode.array.hard;

import java.util.*;

/**
 * @author liyu
 * date 2022/1/11 9:38
 * description 逃离大迷宫
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。
 * 数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 无法向北或者向东移动是因为方格禁止通行。
 * 无法向南或者向西移动是因为不能走出网格。
 * <p>
 * 示例 2：
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格
 * <p>
 * 提示：
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= xi, yi < 106
 * source.length == target.length == 2
 * 0 <= sx, sy, tx, ty < 106
 * source != target
 * 题目数据保证 source 和 target 不在封锁列表内
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-a-large-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class escape_a_large_maze {
    // 在包围圈中
    static final int BLOCKED = -1;
    // 不在包围圈中
    static final int VALID = 0;
    // 无论在不在包围圈中，但在 n(n-1)/2 步搜索的过程中经过了 target
    static final int FOUND = 1;

    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static final int BOUNDARY = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return true;
        }

        Set<Pair> hashBlocked = new HashSet<Pair>();
        for (int[] pos : blocked) {
            hashBlocked.add(new Pair(pos[0], pos[1]));
        }

        int result = check(blocked, source, target, hashBlocked);
        if (result == FOUND) {
            return true;
        } else if (result == BLOCKED) {
            return false;
        } else {
            result = check(blocked, target, source, hashBlocked);
            return result != BLOCKED;
        }
    }

    public int check(int[][] blocked, int[] start, int[] finish, Set<Pair> hashBlocked) {
        int sx = start[0], sy = start[1];
        int fx = finish[0], fy = finish[1];
        int countdown = blocked.length * (blocked.length - 1) / 2;
        Pair startPair = new Pair(sx, sy);
        Queue<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(startPair);
        Set<Pair> visited = new HashSet<Pair>();
        visited.add(startPair);
        while (!queue.isEmpty() && countdown > 0) {
            Pair pair = queue.poll();
            int x = pair.x, y = pair.y;
            for (int d = 0; d < 4; ++d) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                Pair newPair = new Pair(nx, ny);
                if (nx >= 0 && nx < BOUNDARY && ny >= 0 && ny < BOUNDARY && !hashBlocked.contains(newPair) && !visited.contains(newPair)) {
                    if (nx == fx && ny == fy) {
                        return FOUND;
                    }
                    --countdown;
                    queue.offer(newPair);
                    visited.add(newPair);
                }
            }
        }
        if (countdown > 0) {
            return BLOCKED;
        }
        return VALID;
    }

    public boolean isEscapePossible2(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return true;
        }
        // 离散化
        TreeSet<Integer> rows = new TreeSet<Integer>();
        TreeSet<Integer> columns = new TreeSet<Integer>();
        for (int[] pos : blocked) {
            rows.add(pos[0]);
            columns.add(pos[1]);
        }
        rows.add(source[0]);
        rows.add(target[0]);
        columns.add(source[1]);
        columns.add(target[1]);

        Map<Integer, Integer> rMapping = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cMapping = new HashMap<Integer, Integer>();

        int firstRow = rows.first();
        int rId = (firstRow == 0 ? 0 : 1);
        rMapping.put(firstRow, rId);
        int prevRow = firstRow;
        for (int row : rows) {
            if (row == firstRow) {
                continue;
            }
            rId += (row == prevRow + 1 ? 1 : 2);
            rMapping.put(row, rId);
            prevRow = row;
        }
        if (prevRow != BOUNDARY - 1) {
            ++rId;
        }

        int firstColumn = columns.first();
        int cId = (firstColumn == 0 ? 0 : 1);
        cMapping.put(firstColumn, cId);
        int prevColumn = firstColumn;
        for (int column : columns) {
            if (column == firstColumn) {
                continue;
            }
            cId += (column == prevColumn + 1 ? 1 : 2);
            cMapping.put(column, cId);
            prevColumn = column;
        }
        if (prevColumn != BOUNDARY - 1) {
            ++cId;
        }

        int[][] grid = new int[rId + 1][cId + 1];
        for (int[] pos : blocked) {
            int x = pos[0], y = pos[1];
            grid[rMapping.get(x)][cMapping.get(y)] = 1;
        }

        int sx = rMapping.get(source[0]), sy = cMapping.get(source[1]);
        int tx = rMapping.get(target[0]), ty = cMapping.get(target[1]);

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{sx, sy});
        grid[sx][sy] = 1;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1];
            for (int d = 0; d < 4; ++d) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                if (nx >= 0 && nx <= rId && ny >= 0 && ny <= cId && grid[nx][ny] != 1) {
                    if (nx == tx && ny == ty) {
                        return true;
                    }
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = 1;
                }
            }
        }
        return false;
    }

}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (int) ((long) x << 20 | y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair2 = (Pair) obj;
            return x == pair2.x && y == pair2.y;
        }
        return false;
    }

}
