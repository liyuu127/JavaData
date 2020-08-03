package leetCode.array.general;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2020/8/3 9:16
 * description 字符串相加
 * 给定两个字符串形式的非负整数?num1 和num2?，计算它们的和。
 * 注意：
 * num1 和num2?的长度都小于 5100.
 * num1 和num2 都只包含数字?0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库，?也不能直接将输入的字符串转换为整数形式。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class AddStrings {

    public static void main(String[] args) {
        String s = addStrings("1", "9");
        System.out.println("s = " + s);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int c = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || c > 0) {
            if (i >= 0 && j >= 0) {
                int sum = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + c;
                sb.append(sum % 10);
                c = sum / 10;

            } else if (i >= 0 || j >= 0) {
                int sum = i >= 0 ? num1.charAt(i--) - '0' + c : +num2.charAt(j--) - '0' + c;
                sb.append(sum % 10);
                c = sum / 10;
            } else {
                sb.append(c);
                c = 0;
            }
        }
        return sb.reverse().toString();
    }
}
