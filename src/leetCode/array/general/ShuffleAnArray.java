package leetCode.array.general;

import java.util.Random;

/**
 * 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShuffleAnArray {
    int[] nums;
    int[] original;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    /**
     * Fisher-Yates 洗牌算法*
     * 考虑通过调整 waiting 的实现方式以优化。
     * 我们可以在移除 waiting 的第 k 个元素时，将第 k 个元素与数组的最后 1 个元素交换，然后移除交换后数组的最后 1 个元素，
     * 这样我们只需要 O(1) 的时间复杂度即可完成移除第 k 个元素的操作。
     * 此时，被移除的交换后数组的最后 1 个元素即为我们根据随机下标获取的元素。
     * 在此基础上，我们也可以不移除最后 1 个元素，而直接将其作为乱序后的结果，并更新待乱序数组的长度，从而实现数组的原地乱序。
     * 因为我们不再需要从数组中移除元素，所以也可以将第 k 个元素与第 1 个元素交换。
     * 具体地，实现算法如下：
     * 设待原地乱序的数组nums。
     * 循环 n 次，在第 i 次循环中（0≤i<n）：
     * 在 [i,n)中随机抽取一个下标 j；
     * 将第 i 个元素与第 j 个元素交换。
     * 其中数组中的 nums[i .. n−1] 的部分为待乱序的数组，其长度为 n−i；nums[0 .. i−1] 的部分为乱序后的数组，其长度为 i。
     *
     * @return
     */
    public int[] shuffle() {
        Random random = new Random();
        //n! = n * (n-1)!
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
