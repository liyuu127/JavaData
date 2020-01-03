package algorithm.dynamicprogramming;

/**
 * @author liyu
 * @date 2020/1/2 18:48
 * @description 已知包含n个元素的序列A(1)。。。A(2),设计算法寻找一个连续子序列A(i)。。。A(j)，使其子序列的元素之和最大，要求不能寻选取两个相邻的元素
 */
public class MaxSumWithNoTwoContinuousNumbers {
    public static void main(String[] args) {
        int i = maxSumWithNoTwoContinuousNumbers(new int[]{-1, 4, 9, 2});
        System.out.println("i = " + i);
    }

    /**
     * M[i] i为末端的最大结果序列
     * M[i]
     * = A[1] ,n=1
     * = Max{A[1],A[2]},n=2
     * =max{M[n-2]+A[i],M[n-1]}
     *
     * @param A
     * @return
     */
    public static int maxSumWithNoTwoContinuousNumbers(int[] A) {
        int length = A.length;
        int[] M = new int[length];
        if (length == 1) {
            return A[0];
        } else if (length == 2) {
            return Math.max(A[0], A[1]);
        } else {
            int max = 0;
            for (int i = 2; i < length; i++) {
                M[i] = Math.max(M[i - 2] + A[i], M[i - 1]);
                max = Math.max(max, M[i]);
            }
            return max;
        }
    }
}
