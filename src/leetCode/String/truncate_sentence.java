package leetCode.String;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2021/12/6 10:00
 * description  截断句子
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s和一个整数 k，请你将 s截断 ，使截断后的句子仅含 前 k个单词。返回截断s后得到的句子。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 * <p>
 * 示例 2：
 * 输入：s = "What is the solution to this problem", k = 4
 * 输出："What is the solution"
 * 解释：
 * s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
 * 前 4 个单词为 ["What", "is", "the", "solution"]
 * 因此，应当返回 "What is the solution"
 * <p>
 * 示例 3：
 * 输入：s = "chopper is not a tanuki", k = 5
 * 输出："chopper is not a tanuki"
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * k 的取值范围是 [1,  s 中单词的数目]
 * s 仅由大小写英文字母和空格组成
 * s 中的单词之间由单个空格隔开
 * 不存在前导或尾随空格
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/truncate-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class truncate_sentence {
    public static void main(String[] args) {
        String hello_how_are_you_contestant = truncateSentence("Hello how are you Contestant", 1);
        System.out.println("hello_how_are_you_contestant = " + hello_how_are_you_contestant);
    }
    public String truncateSentence(String s, int k) {
        return dfs(s,k,0);
    }

    private String dfs(String s, int k, int start) {
        if (k == 0) {
            return s.substring(0, start-1);
        }
        int i = s.indexOf(" ", start);
        start = i == -1 ? s.length() : i;
        return dfs(s, --k, ++start);
    }
}
