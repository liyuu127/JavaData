package leetCode.other;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 * 提示：
 * 0 <= n <= 104
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class factorial_trailing_zeroes {
    public static void main(String[] args) {
        int i = trailingZeroes(10);
    }
    public static int trailingZeroes(int n) {

        int[] number = new int[n + 1];
        for (int i = 5; i <= n; i++) {
            if (i % 5 == 0) {
                number[i]=number[i/5 ]+1;
            }
        }
        int sum = Stream.of(number).flatMapToInt(Arrays::stream).sum();
        System.out.println("sum = " + sum);
        return sum;
    }
    public int trailingZeroes2(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;

    }
}
