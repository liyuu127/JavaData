package leetCode.array.general;

/**
 * @author liyu
 * date 2022/6/14 14:19
 * description 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class diagonal_traverse {


    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[] cnt = new int[n * m];

        int i = 0, j = 0, k = 0;
        boolean up = true;
        while (k < m * n) {
            cnt[k++] = mat[i][j];
            if (up) {
                if (i - 1 < 0 || j + 1 >= n) {
                    up = false;
                    if (j + 1 < n) {
                        j++;
                    } else {
                        i++;
                    }
                }else {
                    i--;
                    j++;
                }


            } else {
                if (j - 1 < 0 || i + 1 >= m) {
                    up = true;
                    if (i + 1 < m) {
                        i++;
                    } else {
                        j++;
                    }
                }else {
                    i++;
                    j--;
                }

            }
        }

        return cnt;

    }
}
