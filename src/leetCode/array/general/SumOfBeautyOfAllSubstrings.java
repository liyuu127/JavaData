package leetCode.array.general;

/**
 * @author liyu
 * date 2022/12/12 9:07
 * description 1781. �������ַ�������ֵ֮��
 * һ���ַ����� ����ֵ ����Ϊ������Ƶ������ַ������Ƶ������ַ��ĳ��ִ���֮�
 * �ȷ�˵��"abaacc" ������ֵΪ 3 - 1 = 2 ��
 * ����һ���ַ��� s �����㷵�����������ַ����� ����ֵ ֮�͡�
 * ʾ�� 1��
 * ���룺s = "aabcb"
 * �����5
 * ���ͣ�����ֵ��Ϊ����ַ������� ["aab","aabc","aabcb","abcb","bcb"] ��ÿһ���ַ���������ֵ��Ϊ 1 ��
 * ʾ�� 2��
 * ���룺s = "aabcbaa"
 * �����17
 * ��ʾ��
 * 1 <= s.length <= 500
 * s ֻ����СдӢ����ĸ��
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
