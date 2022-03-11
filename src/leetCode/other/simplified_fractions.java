package leetCode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * date 2022/2/10 8:40
 * description 最简分数
 * Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive)
 * such that the denominator is less-than-or-equal-to n. You can return the answer in any order.
 * Example 1:
 * Input: n = 2
 * Output: ["1/2"]
 * Explanation: "1/2" is the only unique fraction with a denominator less-than-or-equal-to 2.
 * Example 2:
 * Input: n = 3
 * Output: ["1/2","1/3","2/3"]
 * Example 3:
 * Input: n = 4
 * Output: ["1/2","1/3","1/4","2/3","3/4"]
 * Explanation: "2/4" is not a simplified fraction because it can be simplified to "1/2".
 * Constraints:
 * <p>
 * 1 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplified-fractions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class simplified_fractions {
    public static void main(String[] args) {
        gcd(10, 1000);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<String>();
        for (int denominator = 2; denominator <= n; ++denominator) {
            for (int numerator = 1; numerator < denominator; ++numerator) {
                if (gcd(numerator, denominator) == 1) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}


