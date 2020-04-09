package leetCode.backtracking.gen;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * @date 2020/4/9 9:15
 * @description 生成括号
 * 数字 n?代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generator(list, n, new StringBuilder(), 0, 0);
        dfs("", 0, 0, n, new ArrayList<>());
        System.out.println("list = " + list);
        return list;

    }

    /**
     * 回溯生成
     *
     * @param result 结果集
     * @param n
     * @param cur
     * @param left   左括号个数
     * @param right  右括号个数
     */
    public void generator(List<String> result, int n, StringBuilder cur, int left, int right) {
        if (cur.length() == 2 * n) {
            result.add(cur.toString());
            return;
        }
        if (left < n) {
            cur.append("(");
            generator(result, n, cur, left + 1, right);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(")");
            generator(result, n, cur, left, right + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * 和上面一样，但是注意参数传递导致cur并没有变
     *
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

    /**
     * 动态规划方式
     *第 1 步：定义状态 dp[i]：使用 i 对括号能够生成的组合。
     *
     * 第 2 步：状态转移方程：
     * i 对括号的一个组合，在 i - 1 对括号的基础上得到，这是思考 “状态转移方程” 的基础；
     * i 对括号的一个组合，一定以左括号 "(" 开始，不一定以 ")" 结尾。为此，我们可以枚举新的右括号 ")" 可能所处的位置，得到所有的组合；
     * 枚举的方式就是枚举左括号 "(" 和右括号 ")" 中间可能的合法的括号对数，而剩下的合法的括号对数在与第一个左括号 "(" 配对的右括号 ")" 的后面，这就用到了以前的状态。
     * 状态转移方程是：
     * dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
     * “可能的括号对数” 与 “剩下的括号对数” 之和得为 i - 1，故 “可能的括号对数” j 可以从 0 开始，最多不能超过 i， 即 i - 1；
     * “剩下的括号对数” + j = i - 1，故 “剩下的括号对数” = i - j - 1。
     * 整理得：
     * dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
     *
     *第 3 步： 思考初始状态和输出：
     * 初始状态：因为我们需要 0 对括号这种状态，因此状态数组 dp 从 0 开始，0 个括号当然就是 [""]。
     * 输出：dp[n] 。
     * 这个方法暂且就叫它动态规划，这么用也是很神奇的，它有下面两个特点：
     * 1、自底向上：从小规模问题开始，逐渐得到大规模问题的解集；
     * 2、无后效性：后面的结果的得到，不会影响到前面的结果。
     * @param n
     * @return
     */
    public List<String> generateParenthesisDY(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }


}
