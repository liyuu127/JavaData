package leetCode.dp;

/**
 * @author liyu
 * date 2022/12/22 9:53
 * description 1799. N �β��������������
 * ���� nums ������һ����СΪ 2 * n �����������顣�������������ִ�� n �β�����
 * �ڵ� i �β���ʱ��������Ŵ� 1 ��ʼ��������Ҫ��
 * ѡ������Ԫ�� x �� y ��
 * ��÷��� i * gcd(x, y) ��
 * �� x �� y �� nums ��ɾ����
 * ���㷵�� n �β��������ܻ�õķ��������Ϊ���١�
 * ���� gcd(x, y) �� x �� y �����Լ����
 * ʾ�� 1��
 * ���룺nums = [1,2]
 * �����1
 * ���ͣ����Ų����ǣ�
 * (1 * gcd(1, 2)) = 1
 * ʾ�� 2��
 * ���룺nums = [3,4,6,8]
 * �����11
 * ���ͣ����Ų����ǣ�
 * (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
 * ʾ�� 3��
 * ���룺nums = [1,2,3,4,5,6]
 * �����14
 * ���ͣ����Ų����ǣ�
 * (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
 * ��ʾ��
 * dp[s]=max{dp[s?2i?2j]+ ts/2 �� gcd(nums[i],nums[j])},i,j��s&i<j
 * <p>
 * <p>
 * 1 <= n <= 7
 * nums.length == 2 * n
 * 1 <= nums[i] <= 106
 * ���ߣ����۹ٷ����
 * ���ӣ�https://leetcode.cn/problems/maximize-score-after-n-operations/solutions/2028201/n-ci-cao-zuo-hou-de-zui-da-fen-shu-he-by-i9k5/
 * ��Դ�����ۣ�LeetCode��
 * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
public class MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        int m = nums.length;
        int[] dp = new int[1 << m];
        int[][] gcdTmp = new int[m][m];
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                gcdTmp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int all = 1 << m;
        for (int s = 1; s < all; ++s) {
            int t = Integer.bitCount(s);
            if ((t & 1) != 0) {
                continue;
            }
            for (int i = 0; i < m; ++i) {
                if (((s >> i) & 1) != 0) {
                    for (int j = i + 1; j < m; ++j) {
                        if (((s >> j) & 1) != 0) {
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcdTmp[i][j]);
                        }
                    }
                }
            }
        }
        return dp[all - 1];
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
