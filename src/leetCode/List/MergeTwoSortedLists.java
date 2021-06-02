package leetCode.List;

/**
 * @author liyu
 * date 2021/6/2 18:39
 * description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {
    public SingleListNode mergeTwoLists(SingleListNode l1, SingleListNode l2) {
        SingleListNode temp = new SingleListNode(-1);
        SingleListNode pre = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) {
            pre.next = l1;
        } else {
            pre.next = l2;
        }
        return temp.next;
    }
}
