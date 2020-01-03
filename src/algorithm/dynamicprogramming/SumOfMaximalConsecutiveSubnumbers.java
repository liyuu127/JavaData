package algorithm.dynamicprogramming;

/**
 * @author liyu
 * @date 2020/1/2 17:19
 * @description 最大连续子数列和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class SumOfMaximalConsecutiveSubnumbers {
    public static void main(String[] args) {
        int a = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int b = maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int c = maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    /**
     * 考虑全负数情况
     *
     * @param nums
     * @return
     */
    public static int maxSumSub(int[] nums) {
        //验证是否全是负数
        int n = 0;
        int max = nums[0];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 0) {
                n++;
            }
            max = max > nums[j] ? max : nums[j];
        }
        if (n == nums.length) {
            return max;
        }

        return maxSubArray(nums);
    }

    /**
     * 动态规划
     * M[i] 以i为末端的所有窗口最大和
     * M[i]=Max{M[i-1]+A[i],0}
     *
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int[] M = new int[nums.length];
        int maxSum = 0;
        if (nums[0] > 0) {
            M[0] = nums[0];
        } else {
            M[0] = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            M[i] = Math.max(M[i - 1] + nums[i], 0);
            maxSum = Math.max(M[i], maxSum);
        }
        return maxSum;
    }

    /**
     * 正增益特性解决
     *
     * @param nums
     * @return
     */
    private static int maxSubArray2(int[] nums) {
        int maxSum = 0, nowMax = 0;
        for (int i = 0; i < nums.length; i++) {
            nowMax = nowMax + nums[i];
            if (nowMax < 0) {
                nowMax = 0;
                continue;
            } else {
                maxSum = Math.max(nowMax, maxSum);
            }
        }

        return maxSum;
    }

    /**
     * 动态规划
     * M[i] 以i为起始端的所有窗口最大和
     * M[i]=Max{M[i+1]+A[i],0}
     *
     * @param nums
     * @return
     */
    private static int maxSubArray3(int[] nums) {
        int[] M = new int[nums.length];
        int maxSum = 0;
        if (nums[nums.length-1] > 0) {
            M[nums.length-1] = nums[nums.length-1];
        } else {
            M[nums.length-1] = 0;
        }
        for (int i = nums.length; i > 1; i--) {
            M[i - 2] = Math.max(M[i-1] + nums[i - 2], 0);
            maxSum = Math.max(M[i - 2], maxSum);
        }
        return maxSum;
    }


}
