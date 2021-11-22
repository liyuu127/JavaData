package leetCode.array.simple;

import java.util.Arrays;

/**
 * ���г������
 * ��г������ָһ��������Ԫ�ص����ֵ����Сֵ֮��Ĳ�� ������ 1 ��
 * ���ڣ�����һ���������� nums �����������п��ܵ����������ҵ���ĺ�г�����еĳ��ȡ�
 * �������������һ���������������������У�������ͨ��ɾ��һЩԪ�ػ�ɾ��Ԫ�ء��Ҳ��ı�����Ԫ�ص�˳����õ���
 * ���룺nums = [1,3,2,2,5,2,3,7]
 * �����5
 * ���ͣ���ĺ�г�������� [3,2,2,2,3]
 * ���룺nums = [1,1,1,1]
 * �����0
 * 1 <= nums.length <= 2 * 104
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        Arrays.sort(nums);

        int l = 0, r = 0;
        int max = 0;
        while (r < length) {
            while (nums[r] - nums[l] > 1) {
                l++;
            }
            if (nums[r] - nums[l] == 1) {
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        return max;

    }
}
