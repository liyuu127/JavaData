package leetCode.array.general;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * date 2021/12/30 9:14
 * description 一手顺子
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class hand_of_straights {
    public static void main(String[] args) {
//        boolean nStraightHand = isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4);
//        System.out.println("nStraightHand = " + nStraightHand);
        boolean nStraightHand2 = isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3);
        System.out.println("nStraightHand2 = " + nStraightHand2);

    }
    public boolean isNStraightHand(int[] hand, int groupSize) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int length = hand.length;
        if (groupSize > length) return false;
        for (int i = 0; i < length; i++) {
            queue.add(hand[i]);
        }
        List<Integer> list = new ArrayList<>();
        while (groupSize <= queue.size()) {
            int i = groupSize - 1;
            Integer pre = queue.poll();
            while (queue.size() > 0 && i > 0) {
                Integer next = queue.poll();
                if (next == pre + 1) {
                    i--;
                    pre = next;
                } else {
                    list.add(next);
                }
            }
            if (i > 0) return false;
            if (list.size()>0) {
                queue.addAll(list);
                list.clear();
            }
        }
        return queue.size() == 0;

    }
    public boolean isNStraightHand0(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : hand) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!cnt.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!cnt.containsKey(num)) {
                    return false;
                }
                cnt.put(num, cnt.get(num) - 1);
                if (cnt.get(num) == 0) {
                    cnt.remove(num);
                }
            }
        }
        return true;
    }
}
