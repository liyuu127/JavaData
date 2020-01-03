package algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/1/2 13:57
 * @description 最长公共子序列LCS
 * 最长公共子序列
 * 什么是子序列：
 * 例如对于字符串"saabcd"，s,a,a是其一个子序列，s,a,b,d也是一个子序列。子序列不要求连续性。
 * 最长公共子序列问题有最优子结构，这个问题可以分解称为更小的问题，因此整个问题就变简单了。同时，子问题的解释可以被重复使用的，也就是说更高级别的子问题会重用更小子问题的解。满足这两点以后，很容易就想到用动态规划来求解。
 * <p>
 * 1.假设两个字符串s1, s2。当其中一个串的长度为0时，公共子序列的长度肯定为0。
 * 2.假设s1的第i个字符与s2的第j个字符相等时，最长子序列等于s1的第i-1个字符与s2的第j-1个字符最长子序列长度+1。
 * 3.假设s1的第i个字符与s2的第j个字符不相等时，最长子序列等于s1的第i个字符与s2的第j-1个字符最长子序列长度或s1的第i-1个字符与s2的第j个字符最长子序列长度中最大那一个。
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int[][] ints = lcsLength(s1, s2);
        for (int i = 0; i < ints.length; i++) {
            String s = Arrays.toString(ints[i]);
            System.out.println(s);
        }
        String lcs = lcs(s1, s2);
        String lcs2 = lcs2(s1, s2);
        System.out.println("lcs = " + lcs);
        System.out.println("lcs2 = " + lcs2);
    }

    /**
     * 自底向上
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int[][] lcsLength(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp;
    }

    public static String lcs(String s1, String s2) {
        int[][] dp = lcsLength(s1, s2);
        int l1 = s1.length();
        int l2 = s2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < l1 && j < l2) {

            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                j++;
                i++;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return sb.toString();
    }


    /**
     * 自上向下
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int[][] lcsLength2(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    public static String lcs2(String s1, String s2) {
        int[][] dp = lcsLength2(s1, s2);
        int i = s1.length(), j = s2.length();
        StringBuilder sb = new StringBuilder();
        while (i >= 1 && j >= 1) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    // 说明相同的字符在行这边，下次遍历的时候应该是同一行，列向前退一格，所以j--
                    j--;
                } else {
                    i--;
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
