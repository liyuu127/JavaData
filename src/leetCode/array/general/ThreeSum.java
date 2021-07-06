package leetCode.array.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyu
 * date 2021/7/6 10:16
 * description ����֮��
 * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 * ʾ�� 1��
 * ���룺nums = [-1,0,1,2,-1,-4]
 * �����[[-1,-1,2],[-1,0,1]]
 * ʾ�� 2��
 * ���룺nums = []
 * �����[]
 * ʾ�� 3��
 * ���룺nums = [0]
 * �����[]
 * ��ʾ��
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/3sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ThreeSum {
    public static void main(String[] args) {

        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("lists = " + lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = a + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    while (l < r) {
                        if (nums[l] == nums[l + 1]) {
                            l++;
                        }
                        if (nums[r] == nums[r - 1]) {
                            r--;
                        }
                    }

                } else if (sum < 3) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }
        public List<List<Integer>> threeSum0(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // ö�� a
            for (int first = 0; first < n; ++first) {
                // ��Ҫ����һ��ö�ٵ�������ͬ
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c ��Ӧ��ָ���ʼָ����������Ҷ�
                int third = n - 1;
                int target = -nums[first];
                // ö�� b
                for (int second = first + 1; second < n; ++second) {
                    // ��Ҫ����һ��ö�ٵ�������ͬ
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // ��Ҫ��֤ b ��ָ���� c ��ָ������
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // ���ָ���غϣ����� b ����������
                    // �Ͳ��������� a+b+c=0 ���� b<c �� c �ˣ������˳�ѭ��
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }

}
