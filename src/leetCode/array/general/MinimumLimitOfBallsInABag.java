package leetCode.array.general;

import java.util.Arrays;

/**
 * @author liyu
 * date 2022/12/20 9:07
 * description 1760. ������������Ŀ����
 * ����һ���������� nums ������ nums[i] ��ʾ�� i �������������Ŀ��ͬʱ����һ������ maxOperations ��
 * ����Խ������²������� maxOperations �Σ�
 * ѡ������һ�����ӣ��������������ֵ� 2 ���µĴ����У�ÿ�������ﶼ�� ������ ����
 * �ȷ�˵��һ���������� 5 ��������԰����Ƿֵ������´�����ֱ��� 1 ���� 4 ���򣬻��߷ֱ��� 2 ���� 3 ����
 * ��Ŀ����ǵ�������������Ŀ�� ���ֵ ������Ҫ ��С�� ������
 * ���㷵�ؽ����������������С������
 * ʾ�� 1��
 * ���룺nums = [9], maxOperations = 2
 * �����3
 * ���ͣ�
 * - ��װ�� 9 ����Ĵ��ӷֳ�װ�� 6 ���� 3 ����Ĵ��ӡ�[9] -> [6,3] ��
 * - ��װ�� 6 ����Ĵ��ӷֳ�װ�� 3 ���� 3 ����Ĵ��ӡ�[6,3] -> [3,3,3] ��
 * װ�������Ĵ�����װ�� 3 �������Կ���Ϊ 3 ������ 3 ��
 * ʾ�� 2��
 * ���룺nums = [2,4,8,2], maxOperations = 4
 * �����2
 * ���ͣ�
 * - ��װ�� 8 ����Ĵ��ӷֳ�װ�� 4 ���� 4 ����Ĵ��ӡ�[2,4,8,2] -> [2,4,4,4,2] ��
 * - ��װ�� 4 ����Ĵ��ӷֳ�װ�� 2 ���� 2 ����Ĵ��ӡ�[2,4,4,4,2] -> [2,2,2,4,4,2] ��
 * - ��װ�� 4 ����Ĵ��ӷֳ�װ�� 2 ���� 2 ����Ĵ��ӡ�[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] ��
 * - ��װ�� 4 ����Ĵ��ӷֳ�װ�� 2 ���� 2 ����Ĵ��ӡ�[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] ��
 * װ�������Ĵ�����װ�� 2 �������Կ���Ϊ 2 ������ 2 ��
 * ʾ�� 3��
 * ���룺nums = [7,17], maxOperations = 2
 * �����7
 * ��ʾ��
 * 1 <= nums.length <= 105
 * 1 <= maxOperations, nums[i] <= 109
 */
public class MinimumLimitOfBallsInABag {
    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();

        int ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int op = 0;
            for (int num : nums) {
                op += (num - 1) / mid;
            }

            if (op <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = minimumSize(new int[]{431, 922, 158, 60, 192, 14, 788, 146, 788, 775, 772, 792, 68, 143, 376, 375, 877, 516, 595, 82, 56, 704, 160, 403, 713, 504, 67, 332, 26}, 80);
//        int i = minimumSize(new int[]{2, 4, 8, 2}, 4);
        System.out.println("i = " + i);
    }
}
