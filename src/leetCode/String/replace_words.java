package leetCode.String;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author liyu
 * date 2022/7/7 11:24
 * description 单词替换
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。
 * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 * 示例 1：
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * <p>
 * 提示：
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class replace_words {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a", "b", "c");
////        String s = replaceWords(list, "aadsfasf absbs bbab cadsfafs");
////        System.out.println("s = " + s);
        Date date = new Date();
        long time = date.getTime();
        System.out.println("String.valueOf(time) = " + String.valueOf(time));
    }

    private static TrieTree root = new TrieTree('/');

    public static String replaceWords(List<String> dictionary, String sentence) {
        TrieTree trieTree = new TrieTree();
        for (String s : dictionary) {
            add(s);
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] s = sentence.split(" ");
        String[] t = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            t[i] = prefix(s[i]);
        }
        return String.join(" ", t);

    }

    public static void add(String s) {
        TrieTree cur = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (cur.child[index] == null) {
                TrieTree trieTree = new TrieTree(s.charAt(i));
                cur.child[index] = trieTree;
            }
            cur = cur.child[index];
        }
        cur.isEnd = true;
    }

    public static String prefix(String s) {
        TrieTree cur = root;
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (cur.child[index] == null) {
                break;
            }
            if (cur.child[index].isEnd) {
                level++;
                break;
            }
            cur = cur.child[index];
            level++;
        }
        if (level == 0) return s;
        else return s.substring(0, level);
    }

    static class TrieTree {
        private TrieTree[] child = new TrieTree[26];
        private char c;
        private boolean isEnd;


        public TrieTree(char c) {
            this.c = c;
        }

        public TrieTree() {
        }

    }
}