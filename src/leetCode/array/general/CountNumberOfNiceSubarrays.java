package leetCode.array.general;

/**
 * @author liyu
 * @date 2020/4/21 14:10
 * @description 统计【优美子数组】
 * 给你一个整数数组?nums 和一个整数 k。
 * 如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2,1,1};
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int i = numberOfSubarrays2(nums, 2);
        System.out.println("i = " + i);
    }

    /**
     * 超时
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            int nk = 0;
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) {
                    nk++;
                }
                if (nk == k) {
                    m++;
                }
                if (nk > k) {
                    break;
                }

            }
        }
        return m;
    }

    /**
     * 双指针法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        // 双指针
        int left = 0, right = 0;
        int count = 0; // 连续子数组中奇数的个数
        int res = 0;
        int preEven = 0; // 记录第一个奇数前面的偶数个数
        while (right < nums.length){
            // 连续子数组中奇数个数不够
            if (count < k){
                if (nums[right] % 2 != 0) count++;
                right++; // 移动右侧指针
            }
            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
            if (count == k) {
                preEven = 0;
                while (count == k){
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    preEven++;
                }
            } else res += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
        }
        return res;
    }


}
