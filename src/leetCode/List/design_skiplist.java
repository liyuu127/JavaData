package leetCode.List;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liyu
 * date 2022/7/26 9:22
 * description 设计跳表
 * 不使用任何库函数，设计一个 跳表 。
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-skiplist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class design_skiplist {
    /**
     * Your Skiplist object will be instantiated and called as such:
     * Skiplist obj = new Skiplist();
     * boolean param_1 = obj.search(target);
     * obj.add(num);
     * boolean param_3 = obj.erase(num);
     */
    class Skiplist {

        static final double P_FACTOR = 0.25;
        static final int MAX_LEVEL = 32;

        int level;
        SkiplistNode head;
        Random random;

        public Skiplist() {
            this.random = new Random();
            this.head = new SkiplistNode(-1, MAX_LEVEL);
            this.level = 1;
        }

        public boolean search(int target) {
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                /* 找到第 i 层小于且最接近 target 的元素*/
                while (curr.forward[i] != null && curr.forward[i].val < target) {
                    curr = curr.forward[i];
                }
            }
            curr = curr.forward[0];
            /* 检测当前元素的值是否等于 target */
            if (curr != null && curr.val == target) {
                return true;
            }
            return false;
        }

        public void add(int num) {
            int lv = randomLevel();
            level = Math.max(level, lv);

            SkiplistNode[] update = new SkiplistNode[level];
            Arrays.fill(update, head);

            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                /* 找到第 i 层小于且最接近 num 的元素*/
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }

            SkiplistNode newNode = new SkiplistNode(num, lv);
            for (int i = 0; i < lv; i++) {
                /* 对第 i 层的状态进行更新，将当前元素的 forward 指向新的节点 */
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }

        }

        public boolean erase(int num) {

            SkiplistNode[] update = new SkiplistNode[level];
            Arrays.fill(update, head);

            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
            curr = curr.forward[0];
            if (curr == null || curr.val != num) return false;

            for (int i = 0; i < level; i++) {
                if (update[i].forward[i] != curr) {
                    break;
                }
                /* 对第 i 层的状态进行更新，将 forward 指向被删除节点的下一跳 */
                update[i].forward[i] = curr.forward[i];
            }

            /* 更新当前的 level */
            while (level > 1 && head.forward[level - 1] == null) {
                level--;
            }
            return true;
        }

        class SkiplistNode {
            int val;
            SkiplistNode pre;
            SkiplistNode[] forward;

            public SkiplistNode(int val, int level) {
                this.val = val;
                this.forward = new SkiplistNode[level];
            }


        }

        int randomLevel() {
            int lv = 1;
            while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
                lv++;
            }
            return lv;
        }

    }
}
