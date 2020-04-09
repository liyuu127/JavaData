package leetCode.fs.gengral;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyu
 * @date 2020/4/8 8:55
 * @description 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k?<= 20
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
 */

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        int i = movingCount(20, 20, 11);
        System.out.println("i = " + i);
        int i1 = movingCountBFS(20, 20, 11);
        System.out.println("i1 = " + i1);
    }

    public static int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, 0, 0, m, n, k, visited);
    }

    /**
     * 深度优先遍历 DFS
     *
     * @param i  当前元素在矩阵中的行索引
     * @param j  当前元素在矩阵中的列索引
     * @param si 数位和i
     * @param sj 数位和j
     * @return 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数
     */
    public static int dfs(int i, int j, int si, int sj, int m, int n, int k, boolean[][] visited) {
//        当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，返回 00 ，代表不计入可达解。
        if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj, m, n, k, visited) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8, m, n, k, visited);
    }

    /**
     * 广度优先遍历 BFS
     * 初始化： 将机器人初始点 (0, 0)(0,0) 加入队列 queue ；
     * 迭代终止条件： queue 为空。代表已遍历完所有可达解。
     * 迭代工作：
     * 单元格出队： 将队首单元格的 索引、数位和 弹出，作为当前搜索单元格。
     * 判断是否跳过： 若 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，执行 continue 。
     * 标记当前单元格 ：将单元格索引 (i, j) 存入 Set visited 中，代表此单元格 已被访问过 。
     * 单元格入队： 将当前元素的 下方、右方 单元格的 索引、数位和 加入 queue 。
     * 返回值： Set visited 的长度 len(visited) ，即可达解的数量。
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public static int movingCountBFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }


}
