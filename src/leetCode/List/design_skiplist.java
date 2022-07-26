package leetCode.List;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liyu
 * date 2022/7/26 9:22
 * description �������
 * ��ʹ���κο⺯�������һ�� ���� ��
 * ���� ���� O(log(n)) ʱ����������ӡ�ɾ�����������������ݽṹ������������������������书���������൱����������Ĵ��볤������¸��̣������˼�����������ơ�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/design-skiplist
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
                /* �ҵ��� i ��С������ӽ� target ��Ԫ��*/
                while (curr.forward[i] != null && curr.forward[i].val < target) {
                    curr = curr.forward[i];
                }
            }
            curr = curr.forward[0];
            /* ��⵱ǰԪ�ص�ֵ�Ƿ���� target */
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
                /* �ҵ��� i ��С������ӽ� num ��Ԫ��*/
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }

            SkiplistNode newNode = new SkiplistNode(num, lv);
            for (int i = 0; i < lv; i++) {
                /* �Ե� i ���״̬���и��£�����ǰԪ�ص� forward ָ���µĽڵ� */
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
                /* �Ե� i ���״̬���и��£��� forward ָ��ɾ���ڵ����һ�� */
                update[i].forward[i] = curr.forward[i];
            }

            /* ���µ�ǰ�� level */
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
