package leetCode.array.general;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2020/12/19 14:08
 * description 旋转图像
 * 给定一个 n?×?n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class RotateImage {

    public static void main(String[] args) {
        rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}});
        System.out.println("args = " + args);
    }

    public void rotate(int[][] matrix) {

        int length = matrix.length;
        if (length < 2) {
            return;
        }
        for (int i = 0; i < (length / 2); i++) {
            for (int j = 0; j < (length - (2 * i) - 1); j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[length - 1 - i - j][i];
                matrix[length - 1 - i - j][i] = matrix[length - 1 - i][length - 1 - i - j];
                matrix[length - 1 - i][length - 1 - i - j] = matrix[i + j][length - 1 - i];
                matrix[i + j][length - 1 - i] = temp;
            }
        }

    }

}
