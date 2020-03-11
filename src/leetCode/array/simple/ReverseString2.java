package leetCode.array.simple;

/**
 * @author liyu
 * @date 2020/3/11 10:26
 * @description 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 */
public class ReverseString2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k=3;
        String s1 = reverseStr(s, k);
        System.out.println("s1 = " + s1);
    }

    public static String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer();
        char[] c = s.toCharArray();
        int i = 0;
        boolean f = true;
        while (i < c.length+k) {
            if (i + k < c.length) {
                if (f) {

                    for (int j = i + k-1; j >= i; j--) {
                        sb.append(c[j]);
                    }
                } else {
                    for (int j = i; j < i + k; j++) {
                        sb.append(c[j]);
                    }
                }
                i = i + k;
                f=!f;
            } else if (i + k >= c.length) {
                if (f) {
                    for (int j = c.length - 1; j >= i; j--) {
                        sb.append(c[j]);
                    }
                } else {
                    for (int j = i; j < c.length; j++) {
                        sb.append(c[j]);
                    }
                }
                break;
            }

        }
        return sb.toString();
    }
}
