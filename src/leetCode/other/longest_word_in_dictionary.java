package leetCode.other;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 词典中最长的单词
 * 给出一个字符串数组words 组成的一本英语词典。返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * 示例 1：
 * <p>
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * 示例 2：
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * 所有输入的字符串words[i]都只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longest_word_in_dictionary {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple", "appla"};
        String s = longestWord(words);
        System.out.println("s = " + s);
        HashSet<String> set = new HashSet<>();
        System.out.println("set.contains(\"\") = " + set.contains(""));
        System.out.println("Arrays.toString(words) = " + Arrays.toString(words));
    }

    public static String longestWord(String[] words) {

        String longestWord = "";
//        Arrays.sort(words, (a, b) -> {
//            int i = a.length() - b.length();
//            if (i == 0) {
//                return a.compareTo(b);
//            } else {
//                return i;
//            }
//        });
//        HashSet<String> set = new HashSet<>();
//        set.add("");
//        int prel = -1;
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            String pre = word.substring(0, word.length() - 1);
//            if (set.contains(pre)) {
//                set.add(word);
//                if (word.length() > prel)
//                    longestWord = word;
//                prel = word.length();
//
//            }
//        }
//
//        return longestWord;
        TireTree tireTree = new TireTree();
        for (int i = 0; i < words.length; i++) {
            tireTree.insert(words[i]);
        }
        for (String word : words) {
            if (tireTree.search(word)) {
                if (word.length() > longestWord.length() || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    static class TireTree {
        private TireTree[] children;
        private boolean isEnd;

        public TireTree() {
            children = new TireTree[26];
            isEnd = false;
        }

        public void insert(String word) {
            TireTree node = this;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (node.children[ch] == null) {
                    node.children[ch] = new TireTree();
                }
                node = node.children[ch];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TireTree node = this;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (node.children[ch] == null || node.children[ch].isEnd) {
                    return false;
                }
                node = node.children[ch];
            }
            return node.isEnd;

        }
    }
}
