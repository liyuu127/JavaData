package leetCode.String;

/**
 * @author liyu
 * date 2022/12/13 9:27
 * description 1832. 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * 输入：sentence = "leetcode"
 * 输出：false
 * 提示：
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 */
public class CheckIfTheSentenceIsPangram {
    public static boolean checkIfPangram(String sentence) {

        int mask = 0;
        int n = sentence.length();

        for (int i = 0; i < n; i++) {
            int j = sentence.charAt(i) - 'a';
            mask |= 1 << j;
        }
        return mask==67108863;
    }

    public static void main(String[] args) {
        int i = Integer.parseInt("11111111111111111111111111", 2);
        System.out.println("i = " + i);
        System.out.println("checkIfPangram(\"thequickbrownfoxjumpsoverthelazydog\") = " + checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
