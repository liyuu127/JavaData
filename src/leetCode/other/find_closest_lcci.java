package leetCode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyu
 * date 2022/5/26 10:49
 * description   面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * 示例：
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 * <p>
 * words.length <= 100000
 */
public class find_closest_lcci {

    public static void main(String[] args) {
        int closest2 = findClosest2(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student");
        System.out.println("closest2 = " + closest2);

    }

    public int findClosest(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;

    }

    public static int findClosest2(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        if (list1 == null || list2 == null) return -1;

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            ans = Math.min(Math.abs(list1.get(i) - list2.get(j)), ans);
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return ans;

    }
}
