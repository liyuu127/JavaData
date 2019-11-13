package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/13 15:16
 * @description 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int nums[]={2,3,1,2,4,3};
        int i = minSubArrayLen(7, nums);
        System.out.println("i = " + i);
    }

    // 双指针 : 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        // 设定nums数组的[l...r]区间元素之和大于等于s
        int l = 0, r = -1;
        int sum = 0;
        while (l < nums.length) {
            if (sum < s){
                if (r == nums.length - 1){
                    break;
                }
                sum += nums[r + 1];
                r++;
            } else {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        if (min == nums.length + 1) {
            return 0;
        }

        return min;

    }
}
