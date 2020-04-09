package leetCode.array.general;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/4/7 8:56
 * @description 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
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
 * <p>
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
 */
public class RotateMatrixLcci {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {

        int length = matrix.length;
        if (length < 2) {
            return;
        }
        int s = length / 2;
        for (int i = 0; i < s; i++) {
            int sr = 0 + i, ec = length - 1 - i;
            for (int j = 0; j < ec-sr; j++) {
                int temp = matrix[sr][sr+j];
                matrix[sr][sr+j] = matrix[ec - j][sr];
                matrix[ec - j][sr] = matrix[ec][ec - j];
                matrix[ec][ec - j] = matrix[sr + j][ec];
                matrix[sr + j][ec] = temp;
            }
        }
        return;
    }
}
