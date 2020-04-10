package leetCode.array.simple;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author liyu
 * @date 2019/11/14 9:00
 * @description 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
@UtilityClass
public class ReverseWords {
    public static void main(String[] args) {
        String s = "a good   example";
        String s1 = reverseWords(s);
        System.out.println("s1 = " +s1);
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] c = s.split("\\s+");
        if (c.length < 2) {
            return s;
        }
        StringBuffer bf = new StringBuffer();
        for (int i = c.length - 1; i > 0; i--) {
            bf.append(c[i]+" ");
        }
        bf.append(c[0]);
        return bf.toString();
    }
}
