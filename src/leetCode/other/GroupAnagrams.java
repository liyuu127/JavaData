package leetCode.other;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * date 2020/12/14 9:24
 * description 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs).forEach(System.out::print);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String, Integer> map = new HashMap();
        int length = strs.length;
        if (length == 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            String s = sortString(strs[i]);
            Integer index = map.get(s);
            if (index == null) {
                List<String> group = new ArrayList();
                group.add(strs[i]);
                result.add(group);
                map.put(s, result.size() - 1);
            } else {
                result.get(index).add(strs[i]);
            }

        }
        return result;
    }

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
