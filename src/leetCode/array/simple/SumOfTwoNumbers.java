package leetCode.array.simple;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liyu
 * @date 2019/11/8 9:02
 * @description 给定一个整数数组 nums?和一个目标值 target，请你在该数组中找出和为目标值的那?两个?整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
@UtilityClass
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int t = 9;
        int[] ints1 = twoSum(ints, t);
        int[] ints2 = twoSum2(ints, t);
        int[] ints3 = twoSumSorted(ints, t);
        System.out.println("ints2 = " + Arrays.toString(ints2));//慢
        System.out.println("ints1 = " + Arrays.toString(ints1));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            if (integerIntegerHashMap.containsKey(complete)) {
                return new int[]{integerIntegerHashMap.get(complete), i};
            }
            integerIntegerHashMap.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (complete == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;

    }

    public int[] twoSumSorted(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{l, r};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;

    }

}
