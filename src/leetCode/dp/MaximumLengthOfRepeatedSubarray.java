package leetCode.dp;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/7/1 8:49
 * @description 最长重复子数组
 * 给两个整数数组?A?和?B?，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * 来源：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 */
@UtilityClass
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 2, 1};
        int B[] = {3, 2, 1, 4, 7};
        int length = findLength(A, B);
        System.out.println("length = " + length);
    }

    /**
     * 动态规划
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {

        int lenA = A.length, lenB = B.length;
        int dp[][] = new int[lenB + 1][lenA + 1];
        int ans = 0;
        for (int i = lenA - 1; i >= 0; i--) {
            for (int j = lenB - 1; j >= 0; j--) {
                dp[i][j] = B[i] == A[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength0(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }
}
