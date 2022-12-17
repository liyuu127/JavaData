package leetCode.array.general;

/**
 * @author liyu
 * date 2022/12/16 9:10
 * description 1785. �����ض�����Ҫ��ӵ�����Ԫ��
 * ����һ���������� nums ������������ limit �� goal ������ nums ��һ����Ҫ���ԣ�abs(nums[i]) <= limit ��
 * ����ʹ����Ԫ���ܺ͵��� goal ����Ҫ����������ӵ� ����Ԫ������ �����Ԫ�� ��Ӧ�ı� ������ abs(nums[i]) <= limit ��һ���ԡ�
 * ע�⣬��� x >= 0 ����ô abs(x) ���� x �����򣬵��� -x ��
 * ʾ�� 1��
 * ���룺nums = [1,-1,1], limit = 3, goal = -4
 * �����2
 * ���ͣ����Խ� -2 �� -3 ��ӵ������У������Ԫ���ܺͱ�Ϊ 1 - 1 + 1 - 2 - 3 = -4 ��
 * ʾ�� 2��
 * ���룺nums = [1,-10,9,1], limit = 100, goal = 0
 * �����1
 * ��ʾ��
 * 1 <= nums.length <= 105
 * 1 <= limit <= 106
 * -limit <= nums[i] <= limit
 * -109 <= goal <= 109
 */
public class MinimumElementsToAddToFormAGivenSum {

    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }


    public static void main(String[] args) {
        int i = minElements(new int[]{1, -1, 1}, 3, -4);
        System.out.println("i = " + i);
    }
}
