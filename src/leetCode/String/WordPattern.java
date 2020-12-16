package leetCode.String;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * date 2020/12/16 9:26
 * description 单词规律
 * 给定一种规律 pattern?和一个字符串?str?，判断 str 是否遵循相同的规律。
 * 这里的?遵循?指完全匹配，例如，?pattern?里的每个字母和字符串?str?中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例?4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设?pattern?只包含小写字母，?str?包含了由单个空格分隔的小写字母。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class WordPattern {

    public static void main(String[] args) {
        boolean b = wordPattern("abba", "dog cat cat dog");
        System.out.println("b = " + b);
        boolean a = wordPattern("abba", "dog cat cat fish");
        System.out.println("a = " + a);
        boolean c = wordPattern("abba", "dog dog dog dog");
        boolean d = wordPattern("aaa", "aa aa aa aa");
        System.out.println("d = " + d);
        System.out.println("c = " + c);
    }

    public boolean wordPattern(String pattern, String s) {
        int length = pattern.length();
        String[] str = s.trim().split(" ");
        if (str.length != length) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>(length);
        Map<String, Character> map2 = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            String value = map1.get(pattern.charAt(i));
            if (value == null) {
                value = str[i];
                Character character = map2.get(value);
                if (character != null) {
                    return false;
                }
                map1.put(pattern.charAt(i), value);
                map2.put(value, pattern.charAt(i));
            } else {
                if (!value.equals(str[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
