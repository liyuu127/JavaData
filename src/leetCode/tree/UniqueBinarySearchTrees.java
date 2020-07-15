package leetCode.tree;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/7/15 8:46
 * @description 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：https://leetcode-cn.com/problems/unique-binary-search-trees
 */
@UtilityClass
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int i = numTrees0(3);
        System.out.println("i = " + i);
    }

    public int numTrees(int n) {

        if (n == 0) {
            return 1;
        }

        int nums = 0;
        for (int i = 0; i < n; i++) {
            nums += numTrees(i) * numTrees(n - i - 1);
        }
        return nums;


    }

    public int numTrees0(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        return dp(n, dp);
    }

    public int dp(int n, int[] dp) {

        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i = 1; i <= n; i++) {
            dp[n] += dp(i - 1, dp) * dp(n - i, dp);
        }
        return dp[n];


    }

    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public int numTrees3(int n) {
        int arr[] = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190};
        return arr[n];
    }

    public int numTrees4(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
