package leetCode.String;

/**
 * @author liyu
 * date 2022/8/10 9:03
 * description 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * 如果方程中只有一个解，要保证返回值 'x' 是一个整数。
 * 示例 1：
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 * 提示:
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/solve-the-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solve_the_equation {
    public static void main(String[] args) {
        String s = solveEquation("x+5-3+x=6+x-2");
        System.out.println("s = " + s);
    }

    public static String solveEquation(String equation) {

        int n = equation.length();
        int x = 0;
        int v = 0;
        int negative = 1;
        int i = 0;
        while (i < n) {
            if (equation.charAt(i) == '=') {
                negative = -1;
                i++;
            }
            int flag = 1;
            if (equation.charAt(i) == '-') {
                flag = -1;
                i++;
            }
            if (equation.charAt(i) == '+') {
                i++;
            }

            int value = 0;
            boolean valid = false;
            while (i < n && Character.isDigit(equation.charAt(i))) {
                value = value * 10 + (equation.charAt(i) - '0');
                i++;
                valid = true;
            }
            if (i < n && equation.charAt(i) == 'x') {
                x += valid ? (flag * negative * value) : (flag * negative);
                i++;
            } else {
                v += flag * negative * value;
            }
        }
        if (x == 0) {
            return v == 0 ? "Infinite solutions" : "No solution";
        }
        if (v % x != 0) {
            return "No solution";
        }
        return "x=" + -v / x;
    }
}
