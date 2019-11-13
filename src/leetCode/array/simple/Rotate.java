package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/13 16:34
 * @description 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums,3);
    }

    public static void rotate(int[] nums, int k) {
        int temp1, temp2, index, count = 0;//count为计数变量，记录移动成功的次数，temp1和temp2是辅助存储变量，为交换元素值之用
        int len = nums.length;
        k %= len;//对k值的前期处理，处理原因是如果k值比len大，那么只有大于len的那部分才是有效移动
        if (k == 0)
            return;//如果k等于0或者k原本是等于len的，那么就相当于没有移动嘛，直接返回
        for (int i = 0; i <= k; i++) //移动的轮数最多k次，当然计数变量count=len的时候会跳出循环
        {
            if (count >= len)
                break;//对计数变量的控制，当所有位置全部移动完了就可以结束了
            index = i;//每轮移动的初始下标
            temp1 = nums[i];
            while ((index + k) % len != i) //一个while循环移动一次
            {
                temp2 = nums[(index + k) % len];
                nums[(index + k) % len] = temp1;
                index = (index + k) % len;
                temp1 = temp2;
                count++;
            }
            nums[i] = temp1;
            count++;
        }

    }
}
