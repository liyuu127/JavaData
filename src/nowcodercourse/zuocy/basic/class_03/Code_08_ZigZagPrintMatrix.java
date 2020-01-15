package nowcodercourse.zuocy.basic.class_03;

/**
 * "之"字形打印矩阵
 */
public class Code_08_ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR < endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
            System.out.println();
        }
    }

    /**
     * 打印指定方向的右上，左下连线
     *
     * @param m
     * @param tR 上方R坐标
     * @param tC 上方C坐标
     * @param dR 下方R坐标
     * @param dC 下方C坐标
     * @param f  方向
     */
    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR < dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR > tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }

}
