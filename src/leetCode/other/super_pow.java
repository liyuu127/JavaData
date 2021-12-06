package leetCode.other;

import lombok.experimental.UtilityClass;

/**
 * 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 示例 1：
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * 提示：
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class super_pow {
    public static void main(String[] args) {
//        int i = superPow(2147483647, new int[]{2, 0, 0});
        int i = superPow(2, new int[]{1, 0});
        System.out.println("i = " + i);
    }

    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    int dfs(int a, int[] b, int u) {
        if (u == -1) return 1;
        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % MOD;
    }
    int qpow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b != 0) {
            if ((b & 1) != 0) ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }
}
