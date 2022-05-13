package leetCode.String;

/**
 * @author liyu
 * date 2022/5/13 9:20
 * description 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class one_away_lcci {
    public static void main(String[] args) {
        boolean b = oneEditAway("teacher", "teachy");
        System.out.println("b = " + b);
    }

    public static boolean oneEditAway(String first, String second) {
        int fl = first.length(), sl = second.length();
        if (Math.abs(fl - sl) > 1) return false;
        int min = Math.min(fl, sl);
        int i = 0;
        while (i < min) {
            if (first.charAt(i) != second.charAt(i)) {
                if (fl == sl) {
                    return first.substring(i + 1).equals(second.substring(i + 1));
                } else if (fl + 1 == sl) {
                    return first.substring(i).equals(second.substring(i + 1));

                } else if (fl - 1 == sl) {
                    return first.substring(i + 1).equals(second.substring(i));
                }
            }
            i++;
        }
        return true;
    }
}
