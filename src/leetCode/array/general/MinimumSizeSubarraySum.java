package leetCode.array.general;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/6/28 9:15
 * @description 长度最小的子数组
 * 给定一个含有?n?个正整数的数组和一个正整数?s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 * 示例:?
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组?[4,3]?是该条件下的长度最小的连续子数组。
 * 进阶:如果你已经完成了O(n) 时间复杂度的解法, 请尝试?O(n log n) 时间复杂度的解法。
 * 来源：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
@UtilityClass
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[]nums={2,3,1,2,4,3};
        int i = minSubArrayLen0(7, nums);
        System.out.println("i = " + i);
    }
    public int minSubArrayLen(int s, int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int l = 0, r = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (r < n) {
            sum += nums[r];
            while (sum >= s) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    public int minSubArrayLen0(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
