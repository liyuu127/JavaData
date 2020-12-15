package leetCode.other;

/**
 * @author liyu
 * date 2020/12/15 10:41
 * description 单调递增的数字
 * @See https://leetcode-cn.com/problems/monotone-increasing-digits
 * 给定一个非负整数?N，找出小于或等于?N?的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字?x?和?y?满足?x <= y?时，我们称这个整数是单调递增的。）
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 说明: N?是在?[0, 10^9]?范围内的一个整数。
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        int i = monotoneIncreasingDigits(332);
        System.out.println("i = " + i);
    }
    public  static int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
