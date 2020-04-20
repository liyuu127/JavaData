package leetCode.array.general;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyu
 * @date 2020/4/17 10:38
 * @description 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例?1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例?2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{3, 2, 1, 0, 4};

        boolean b = canJump2(nums);
        System.out.println("b = " + b);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean flag = false;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                integers.add(i);
            }
        }
        AtomicInteger size = new AtomicInteger(integers.size());
        if (size.get() == 0) {
            return true;
        }
        integers.forEach(i -> {
            for (int j = 0; j < i; j++) {
                if (nums[j] > i - j) {
                    size.getAndDecrement();
                    break;
                }
            }
        });
        if (size.get() == 0) {
            flag = true;
        }
        return flag;
    }

    public static boolean canJump2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
                if (max >= length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
