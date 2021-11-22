package leetCode.array.simple;

import java.util.Arrays;

/**
 * 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * 1 <= nums.length <= 2 * 104
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
