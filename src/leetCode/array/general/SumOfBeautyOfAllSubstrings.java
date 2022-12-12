package leetCode.array.general;

/**
 * @author liyu
 * date 2022/12/12 9:07
 * description 1781. 所有子字符串美丽值之和
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * 示例 1：
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 * 输入：s = "aabcbaa"
 * 输出：17
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class SumOfBeautyOfAllSubstrings {
    public static int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int maxF = 0;
            for (int j = i; j < n; j++) {
                int minF = n;
                int index = s.charAt(j) - 'a';
                int f = count[index] + 1;
                count[index]++;
                if (f > maxF) {
                    maxF = f;
                }

                for (int k = 0; k < 26; k++) {
                    if (count[k] > 0)
                        minF = Math.min(minF, count[k]);
                }

                ans += (maxF - minF);
            }

        }
        return ans;

    }

    public static int beautySum2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int sum = beautySum("fspps");
        int sum2 = beautySum2("fspps");
        System.out.println("fspps = " + sum);
        System.out.println("fspps = " + sum2);
    }
}
