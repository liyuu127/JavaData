package leetCode.other;

import java.util.*;

/**
 * @author liyu
 * date 2022/4/25 9:23
 * description 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * 示例:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class random_pick_index {


    class Solution {
//        Map<Integer, List<Integer>> map;
//
//        public Solution(int[] nums) {
//            map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                List<Integer> list = map.get(nums[i]);
//                if (list == null) {
//                    list = new ArrayList<>();
//                }
//                list.add(i);
//            }
//        }
//
//        public int pick(int target) {
//            List<Integer> list = map.get(target);
//            Random random = new Random();
//            return list.get(random.nextInt(list.size()));
//        }

        Random random = new Random();
        int[] nums;
        public Solution(int[] _nums) {
            nums = _nums;
        }
        public int pick(int target) {
            int n = nums.length, ans = 0;
            for (int i = 0, cnt = 0; i < n; i++) {
                if (nums[i] == target) {
                    cnt++;
                    if (random.nextInt(cnt) == 0) ans = i;
                }
            }
            return ans;
        }

    }
}

