package leetCode.other;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liyu
 * date 2020/12/26 11:37
 * description 最大矩形
 * 给定一个仅包含?0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 提示：
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalRectangle {

    /**
     * 方法一: 使用柱状图的优化暴力方法
     * 思路与算法
     * 最原始地，我们可以列举每个可能的矩形。我们枚举矩形所有可能的左上角坐标和右下角坐标，并检查该矩形是否符合要求。然而该方法的时间复杂度过高，不能通过所有的测试用例，因此我们必须寻找其他方法。
     * 我们首先计算出矩阵的每个元素的左边连续 1 的数量，使用二维数组 left 记录，其中left[i][j] 为矩阵第 i 行第 j 列元素的左边连续 1 的数量。
     * 随后，对于矩阵中任意一个点，我们枚举以该点为右下角的全 1 矩形。
     * 具体而言，当考察以 matrix[i][j] 为右下角的矩形时，我们枚举满足i0≤k≤i 的所有可能的 k，此时矩阵的最大宽度就为
     * left[i][j],left[i?1][j],…,left[k][j]的最小值。
     *
     * <p>
     * 对每个点重复这一过程，就可以得到全局的最大矩形。
     * 我们预计算最大宽度的方法事实上将输入转化成了一系列的柱状图，我们针对每个柱状图计算最大面积。
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

    /**
     * 方法二：单调栈
     * 思路与算法
     * 在方法一中，我们讨论了将输入拆分成一系列的柱状图。为了计算矩形的最大面积，我们只需要计算每个柱状图中的最大面积，并找到全局最大值。
     * 我们可以使用「84. 柱状图中最大的矩形的官方题解」中的单调栈的做法，将其应用在我们生成的柱状图中。
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

}
