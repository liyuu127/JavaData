package leetCode.array.simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liyu
 * date 2021/7/7 9:09
 * description ����Ԫ��
 * ����һ����СΪ n �����飬�ҵ����еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ����?? n/2 ??��Ԫ�ء�
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 * ʾ��?1��
 * ���룺[3,2,3]
 * �����3
 * ʾ��?2��
 * ���룺[2,2,1,1,1,2,2]
 * �����2
 * ���ף�
 * �������ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ���㷨��������⡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/majority-element
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MajorityElement {

    public static void main(String[] args) {
        int i = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println("i = " + i);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) != null && map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * ͶƱ�㷨֤��:
     * �����ѡ�˲���maj �� maj,��������Ǻ�ѡ��һ�𷴶� �ᷴ�Ժ�ѡ��,���Ժ�ѡ��һ������̨(maj==0ʱ��������ѡ��)
     * �����ѡ����maj , ��maj ��֧���Լ���������ѡ�˻ᷴ�ԣ�ͬ����Ϊmaj Ʊ������һ�룬����maj һ����ɹ���ѡ
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
