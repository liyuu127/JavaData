package leetCode.other;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author liyu
 * date 2022/6/15 9:21
 * description 找出第 K 小的数对距离
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * 示例 1：
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * 示例 2：
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * 示例 3：
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 * 提示：
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-th-smallest-pair-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
