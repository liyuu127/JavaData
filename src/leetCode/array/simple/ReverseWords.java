package leetCode.array.simple;

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
public class ReverseWords {
    public static void main(String[] args) {
        String s= "     hello world!  ";
        int c = s.charAt(0);
        int c1 = s.charAt(2);
        System.out.println("c = " + c);
        System.out.println("c1 = " + c1);
        String[] s1 = s.split(" ");
        System.out.println("s1 = " + Arrays.toString(s1));
    }

    public String reverseWords(String s) {

        return s;
    }
}
