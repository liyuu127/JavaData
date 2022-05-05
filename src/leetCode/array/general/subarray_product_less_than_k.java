package leetCode.array.general;

/**
 * @author liyu
 * date 2022/5/5 9:11
 * description 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * 示例 1：
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * 提示: 
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class subarray_product_less_than_k {
    public static void main(String[] args) {
        int i = numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        System.out.println("i = " + i);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k == 0) return 0;
        int cnt = 0;
        int mul = 1;

        for (int i = 0, j = 0; i < nums.length; i++) {
            mul *= nums[i];
            while (j <= i && mul >= k) {
                mul/=nums[j];
                j++;
            }
            cnt += (i-j + 1);
        }
        return cnt;

//        int n = nums.length, ret = 0;
//        int prod = 1, i = 0;
//        for (int j = 0; j < n; j++) {
//            prod *= nums[j];
//            while (i <= j && prod >= k) {
//                prod /= nums[i];
//                i++;
//            }
//            ret += j - i + 1;
//        }
//        return ret;
    }
}
