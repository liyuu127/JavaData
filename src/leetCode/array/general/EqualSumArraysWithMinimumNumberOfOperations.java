package leetCode.array.general;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * date 2022/12/7 9:26
 * description 1775. ͨ�����ٲ�������ʹ����ĺ����
 * �����������ȿ��ܲ��ȵ��������� nums1 �� nums2 �����������е�����ֵ���� 1 �� 6 ֮�䣨���� 1 �� 6����
 * ÿ�β����У������ѡ�� ���� �����е�����һ��������������� 1 �� 6 ֮�� ���� ��ֵ������ 1 �� 6����
 * ���㷵��ʹ nums1 ���������ĺ��� nums2 ���������ĺ���ȵ����ٲ�������������޷�ʹ��������ĺ���ȣ��뷵�� -1 ��
 * ʾ�� 1��
 * ���룺nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * �����3
 * ���ͣ������ͨ�� 3 �β���ʹ nums1 ���������ĺ��� nums2 ���������ĺ���ȡ����������±궼�� 0 ��ʼ��
 * - �� nums2[0] ��Ϊ 6 �� nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] ��
 * - �� nums1[5] ��Ϊ 1 �� nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] ��
 * - �� nums1[2] ��Ϊ 2 �� nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] ��
 * ʾ�� 2��
 * ���룺nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * �����-1
 * ���ͣ�û�а취���� nums1 �ĺͻ������� nums2 �ĺ�ʹ������ȡ�
 * ʾ�� 3��
 * ���룺nums1 = [6,6], nums2 = [1]
 * �����3
 * ���ͣ������ͨ�� 3 �β���ʹ nums1 ���������ĺ��� nums2 ���������ĺ���ȡ����������±궼�� 0 ��ʼ��
 * - �� nums1[0] ��Ϊ 2 �� nums1 = [2,6], nums2 = [1] ��
 * - �� nums1[1] ��Ϊ 2 �� nums1 = [2,2], nums2 = [1] ��
 * - �� nums2[0] ��Ϊ 4 �� nums1 = [2,2], nums2 = [4] ��
 * ��ʾ��
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 */
public class EqualSumArraysWithMinimumNumberOfOperations {
    public int minOperations(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length;
        if (6 * n < m || 6 * m < n) {
            return -1;
        }
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            ++cnt1[i];
            diff += i;
        }
        for (int i : nums2) {
            ++cnt2[i];
            diff -= i;
        }
        if (diff == 0) {
            return 0;
        }
        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        }
        return help(cnt1, cnt2, -diff);
    }

    public int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && diff > 0; --i) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;

    }
}
