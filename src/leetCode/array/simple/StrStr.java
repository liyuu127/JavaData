package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/12 15:49
 * @description 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "aaaaa"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issipi";
        int i = strStr(haystack, needle);
        System.out.println("i = " + i);
        System.out.println("haystack = " + haystack.indexOf(needle));
    }
    public static int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int flg = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

            } else {
                flg++;
                i=flg;
                j = 0;
            }
        }
        if ((haystack.length()-flg<needle.length())||needle.length()>haystack.length()){
            return -1;
        }

            return flg;
    }
}
