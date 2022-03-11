package leetCode.dp;

import java.util.Arrays;

/**
 * @author liyu
 * date 2022/1/17 8:53
 * description 统计元音字母序列的数目
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：68
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-vowels-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class count_vowels_permutation {
    public static void main(String[] args) {
        int i = countVowelPermutation(144);
        System.out.println(i);
    }

    public static int countVowelPermutation(int n) {
        long mod = 1000000007;

        long[] count = new long[5];
        Arrays.fill(count, 1);
        for (int j = 1; j < n; j++) {
            long a = count[0];
            long e = count[1];
            long i = count[2];
            long o = count[3];
            long u = count[4];
            count[0] = (e + i + u) % mod;
            count[1] = (a + i) % mod;
            count[2] = (e + o) % mod;
            count[3] = (i) % mod;
            count[4] = (i + o) % mod;
        }
        long ans = 0;

        for (int i = 0; i < 5; ++i) {
            ans = (ans + count[i]) % mod;
        }
        return (int) ans;
    }
}
