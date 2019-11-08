package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/8 11:41
 * @description 给定一个整数数组 nums?，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释:?连续子数组?[4,-1,2,1] 的和最大，为?6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaximumSubarray {

    //动态规划，时间复杂度o(n)。(单线程最优解)
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }

    //分治法，时间复杂度o(n)，优点是可以并行运算。
    public int maxSubArray2(int[] nums) {
        return mergeCount(nums,0,nums.length)[2];
    }
    /**
     * @return 片段处理后的数组，依次为：左通最大值，右通最大值，局部最大值，总和
     * */
    public int[] mergeCount(int[] nums,int fromIndex,int toIndex){
        int[] result=new int[4];
        if(toIndex-fromIndex!=1){
            int midIndex=(toIndex+fromIndex)>>>1;
            int[] resL=mergeCount(nums,fromIndex,midIndex);
            int[] resR=mergeCount(nums,midIndex,toIndex);
            result[0]=Math.max(resL[0],resL[3]+resR[0]);
            result[1]=Math.max(resR[1],resL[1]+resR[3]);
            result[2]=Math.max(Math.max(resL[2],resR[2]),resL[1]+resR[0]);
            result[3]=resL[3]+resR[3];
            return result;
        }
        Arrays.fill(result,nums[fromIndex]);
        return result;
    }

}

