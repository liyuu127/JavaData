package leetCode.String;

import lombok.experimental.UtilityClass;

import java.util.HashMap;

/**
 * @author liyu
 * date 2020/12/23 9:25
 * description 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        int loveleetcode = firstUniqChar("loveleetcode");
        System.out.println("loveleetcode = " + loveleetcode);
    }
    public int firstUniqChar(String s) {
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i))== 1) {
                return i;
            }
        }
        return -1;
    }
}
