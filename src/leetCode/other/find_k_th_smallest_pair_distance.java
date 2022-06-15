package leetCode.other;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author liyu
 * date 2022/6/15 9:21
 * description �ҳ��� K С�����Ծ���
 * ���� (a,b) ������ a �� b ��ɣ������Ծ��붨��Ϊ a �� b �ľ��Բ�ֵ��
 * ����һ���������� nums ��һ������ k �������� nums[i] �� nums[j] ��������� 0 <= i < j < nums.length ������ �������Ծ����� �� k С�����Ծ��롣
 * ʾ�� 1��
 * ���룺nums = [1,3,1], k = 1
 * �����0
 * ���ͣ����ԺͶ�Ӧ�ľ������£�
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * ����� 1 С�������� (1,1) ������Ϊ 0 ��
 * ʾ�� 2��
 * ���룺nums = [1,1,1], k = 2
 * �����0
 * ʾ�� 3��
 * ���룺nums = [1,6,1], k = 3
 * �����5
 * ��ʾ��
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/find-k-th-smallest-pair-distance
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class find_k_th_smallest_pair_distance {

    public static void main(String[] args) {
        smallestDistancePair(new int[]{1, 6, 1}, 3);
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + right >> 1;
            int cnt = 0;
            for (int i = 0, j = 1; i < n - 1; i++) {
                while (j < n && nums[j] - nums[i] <= mid) {
                    j++;
                }
                while (j >= n || nums[j] - nums[i] > mid) {
                    j--;
                }
                cnt += j - i;
            }

            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;

    }

    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
