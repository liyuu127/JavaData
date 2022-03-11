package leetCode.String;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * date 2021/12/28 15:27
 * description 连接词
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 * <p>
 * 示例 1：
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 * "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 * "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 * <p>
 * 示例 2：
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 0 <= words[i].length <= 1000
 * words[i] 仅由小写字母组成
 * 0 <= sum(words[i].length) <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/concatenated-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class concatenated_words {

    public static void main(String[] args) {
        List<String> allConcatenatedWordsInADict = findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});
        System.out.println("allConcatenatedWordsInADict = " + allConcatenatedWordsInADict);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> list = new ArrayList<>();
        TrieTree trieTree = new TrieTree();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            if (!words[i].equals("")) {
                if (find(trieTree, words[i], 0)) {
                    list.add(words[i]);
                } else {
                    trieTree.insert(words[i].toCharArray());
                }
            }
        }

        return list;

    }

    public boolean find(TrieTree trieTree, String word, int start) {
        int length = word.length();
        for (int i = start; i <= length; i++) {
            if (trieTree.find(word, start, i)) {
                if (i == length) {
                    return start != 0;
                }
                if (find(trieTree, word, i)) return true;
            }
        }
        return false;
    }


    static class TrieTree {
        class TreeNode {
            public char data;
            public TreeNode[] child = new TreeNode[26];
            public boolean endOfWord = false;

            public TreeNode(char data) {
                this.data = data;
            }
        }

        private TreeNode root = new TreeNode('/');

        public void insert(char[] text) {
            TreeNode head = root;
            int length = text.length;
            for (int i = 0; i < length; i++) {
                int index = text[i] - 'a';
                if (head.child[index] == null) {
                    head.child[index] = new TreeNode(text[i]);
                }
                head = head.child[index];
            }
            head.endOfWord = true;
        }

        public boolean find(char[] text) {
            int length = text.length;
            TreeNode head = root;
            for (int i = 0; i < length; i++) {
                int index = text[i] - 'a';
                if (head.child[index] == null) return false;
                head = head.child[index];
            }
            return head.endOfWord;
        }

        public boolean find(String word, int start, int end) {
            TreeNode head = root;
            for (int i = start; i < end; i++) {
                int index = word.charAt(i) - 'a';
                if (head.child[index] == null) return false;
                head = head.child[index];
            }
            return head.endOfWord;
        }
    }
}
