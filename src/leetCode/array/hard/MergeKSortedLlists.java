package leetCode.array.hard;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * @date 2020/4/26 9:13
 * @description 合并k个排序链表
 * 合并?k?个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class MergeKSortedLlists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{node1, node2, node3};
        ListNode node = mergeKLists(lists);
        System.out.println("node = " + node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        boolean flag = true;
        int n = 0;
        int max = 0;
        ListNode temp = new ListNode(-1);
        ListNode root = temp;

        while (flag) {
            ListNode node = null;
            for (int i = 0; i < length; i++) {
                if (lists[i] == null) {
                    n++;
                } else {
                    if (node == null || lists[i].val < node.val) {
                        node = lists[i];
                        max = i;
                    }
                }

            }
            if (n == length) {
                flag = false;
            } else {
                lists[max] = lists[max].next;
                temp.next = node;
                temp = temp.next;
                node = null;
                n = 0;
                max = 0;
            }
        }
        return root.next;
    }

    /**
     * 最小堆
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue((Comparator<ListNode>) (o1, o2) -> (o1.val - o2.val));
        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        //从堆中不断取出元素，并将取出的元素串联起来
        while (!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        //创建一个小根堆，并定义好排序函数
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //这里跟上一版不一样，不再是一股脑全部放到堆中
        //而是只把k个链表的第一个节点放入到堆中
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                queue.add(head);
            }
        }
        //之后不断从堆中取出节点，如果这个节点还有下一个节点，
        //就将下个节点也放入堆中
        while (queue.size() > 0) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        cur.next = null;
        return dummy.next;
    }


    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
