package leetCode.array.simple;

import java.util.ArrayList;

import java.util.List;

/**
 * @author liyu
 * @date 2019/11/14 14:49
 * @description 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        List<Integer> integers = spiralOrder(matrix);
        System.out.println("integers = " + integers);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if (matrix.length==0){
            return list;
        }

        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--,list);
        }
        return list;
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC,List list) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                list.add(m[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                list.add(m[i][tC]);
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                list.add(m[tR][curC]);
                curC++;
            }
            while (curR != dR) {
                list.add(m[curR][dC]);
                curR++;
            }
            while (curC != tC) {
                list.add(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {
                list.add(m[curR][tC]);
                curR--;
            }
        }
    }
}
