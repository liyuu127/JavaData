package leetCode.array.general;


import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liyu
 * @date 2020/7/9 9:00
 * @description 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * 示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * <p>
 * 来源：https://leetcode-cn.com/problems/re-space-lcci
 */
@UtilityClass
public class ReSpaceLcci {

    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;

    public static void main(String[] args) {
        String sentence = "jesslookedjustliketimherbrother";
        String dictionary[] = {"looked", "just", "like", "her", "brother"};
        int respace = respace(dictionary, sentence);
        System.out.println("respace = " + respace);
    }

    /**
     * 定义 dp[i] 表示考虑前 i 个字符最少的未识别的字符数量，从前往后计算 dp 值。
     * 考虑转移方程，每次转移的时候我们考虑第 j(j≤i) 个到第 i 个字符组成的子串 sentence[j?1?i?1]
     * （注意字符串下标从 0 开始）是否能在词典中找到，如果能找到的话按照定义转移方程即为
     * dp[i]=min(dp[i],dp[j?1])
     * 否则没有找到的话我们可以复用dp[i?1] 的状态再加上当前未被识别的第 i 个字符，因此此时 dp 值为
     * dp[i]=dp[i?1]+1
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {

        int length = sentence.length();
        Trie root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }
        int dp[] = new int[length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {

            //考虑无法匹配
            dp[i] = dp[i - 1] + 1;
            Trie cur = root;
            for (int j = i; j >= 1; j--) {

                int t = sentence.charAt(j - 1) - 'a';
                if (cur.next[t] == null) {
                    break;
                } else if (cur.next[t].endFlag) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                cur = cur.next[t];
            }

        }
        return dp[length];
    }

    /**
     * 字符串哈希
     * 预备知识 字符串哈希：可参考「1392. 最长快乐前缀」官方题解中的「背景知识」。
     * 思路和算法
     * 我们使用字典树的目的是查找某一个串 s 是否在一个串的集合 S 当中，并且当我们知道 s 是否在 S 中之后，可以快速的知道在 s 后添加某一个新的字母得到的新串 s′
     * 是否在 S 中，这个转移的过程是 O(1) 的。这是我们采用字典树而放弃使用 HashMap 类容器的一个理由，这些容器不能实现 s 到 s'的 O(1) 转移，但字典树可以。
     * 其实还用一种字符串哈希的方法也能实现 O(1)的转移，就是「预备知识」中提到的 Rabin-Karp 方法。我们用这种方法替换字典树，时间复杂度不变，空间复杂度可以优化到 O(n+q)，
     * 其中 n 为 sentence 中元素的个数，q 为词典中单词的个数。
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace0(String[] dictionary, String sentence) {

        Set<Long> hashValues = new HashSet<Long>();
        for (String word : dictionary) {
            hashValues.add(getHash(word));
        }

        int[] f = new int[sentence.length() + 1];
        Arrays.fill(f, sentence.length());

        f[0] = 0;
        for (int i = 1; i <= sentence.length(); ++i) {
            f[i] = f[i - 1] + 1;
            long hashValue = 0;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a' + 1;
                hashValue = (hashValue * BASE + t) % P;
                if (hashValues.contains(hashValue)) {
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
        }

        return f[sentence.length()];
    }

    public long getHash(String s) {
        long hashValue = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
        }
        return hashValue;
    }
}

/**
 * 简单字典树
 */
class Trie {
    public Trie[] next;
    public boolean endFlag;

    public Trie() {
        this.next = new Trie[26];
        this.endFlag = false;
    }

    public void insert(String s) {

        Trie cur = this;
        for (int i = s.length() - 1; i >= 0; i--) {
            int t = s.charAt(i) - 'a';
            if (cur.next[t] == null) {
                cur.next[t] = new Trie();
            }
            cur = cur.next[t];
        }
        cur.endFlag = true;
    }

}


