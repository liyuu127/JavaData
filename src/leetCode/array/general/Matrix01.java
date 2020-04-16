package leetCode.array.general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyu
 * @date 2020/4/15 8:51
 * @description 01矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * <p>
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Matrix01 {

    public static void main(String[] args) {
;
    }

//    对于 「Tree 的 BFS」 （典型的「单源 BFS」）
//    首先把 root 节点入队，再一层一层无脑遍历就行了。
//    对于 「图 的 BFS」 （「多源 BFS」） 做法其实也是一样滴～，与 「Tree 的 BFS」的区别注意以下两条
//    Tree 只有 1 个 root，而图可以有多个源点，所以首先需要把多个源点都入队；
//    Tree 是有向的因此不需要标识是否访问过，而对于无向图来说，必须得标志是否访问过哦！并且为了防止某个节点多次入队，需要在其入队之前就将其设置成已访问！【 看见很多人说自己的 BFS 超时了，坑就在这里哈哈哈

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];//结果集
        boolean[][] visited = new boolean[m][n];//记录已经计算过的位置
        Queue<int[]> queue = new LinkedList<>();//广搜队列
        //遍历，将等于0的位置计入结果集并入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //四个方向广搜
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            //四个方向上找 1
            for (int k = 0; k < 4; k++) {
                int di = i + direction[k][0], dj = j + direction[k][1];
                //没有计算过的地方一定是 1
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]) {
                    res[di][dj] = res[i][j] + 1;
                    visited[di][dj] = true;
                    queue.offer(new int[]{di, dj});
                }
            }
        }
        return res;
    }
//对于任一点 (i, j)，距离 0 的距离为：
//
//f(i, j) = 1 + min(f(i-1, j), f(i, j-1), f(i+1, j), f(i, j+1)) if matrix[i][j] == 1
//        = 0  if matrix[i][j] == 0


//因此用 dp[i][j]来表示该位置距离最近的 0 的距离。
//我们发现 dp[i][j] 是由其上下左右四个状态来决定，无法从一个方向开始递推！
//于是我们尝试将问题分解：
//距离 (i, j)(i,j) 最近的 00 的位置，是在其 「左上，右上，左下，右下」4个方向之一；
//因此我们分别从四个角开始递推，就分别得到了位于「左上方、右上方、左下方、右下方」距离 (i, j)(i,j) 的最近的 00 的距离，取 min 即可；
    public int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }


}
