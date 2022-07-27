package leetCode.other;

/**
 * @author liyu
 * date 2022/7/27 11:48
 * description 分数加减运算
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * 示例 1:
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 * 提示:
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class fraction_addition_and_subtraction {
    public static String fractionAddition(String expression) {

        long molecular = 0, denominator = 1;
        int n = expression.length(), i = 0;
        while (i < n) {
            int negative = 1;
            if (expression.charAt(i) == '-') {
                negative = -1;
                i++;
            }
            if (expression.charAt(i) == '+') {
                negative = 1;
                i++;
            }
            long molecular1 = 0, denominator1 = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                molecular1 = molecular1 * 10 + expression.charAt(i) - '0';
                i++;
            }
            molecular1 = negative * molecular1;
            i++;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denominator1 = denominator1 * 10 + expression.charAt(i) - '0';
                i++;
            }
            molecular = molecular * denominator1 + molecular1 * denominator;
            denominator = denominator * denominator1;
        }
        long gcd = Math.abs(gcd(molecular, denominator));
        return Long.toString(molecular / gcd) + "/" + Long.toString(denominator / gcd);
    }

    public static void main(String[] args) {
        long gcd = gcd(0, 1);
        System.out.println("gcd = " + gcd);
        String s = fractionAddition("-1/2+1/2");
        System.out.println("s = " + s);
    }
    public static long gcd(long a, long b) {
        long c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
}
