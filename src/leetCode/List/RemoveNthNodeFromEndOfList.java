package leetCode.List;

/**
 * @author liyu
 * date 2021/6/3 11:45
 * description  删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        SingleListNode l1=new SingleListNode(1);
        SingleListNode l2=new SingleListNode(2);
        SingleListNode l3=new SingleListNode(3);
        SingleListNode l4=new SingleListNode(4);
        SingleListNode l5=new SingleListNode(5);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        SingleListNode singleListNode = removeNthFromEnd(l1, 1);
        System.out.println("singleListNode = " + singleListNode);
    }

    public static SingleListNode removeNthFromEnd(SingleListNode head, int n) {
        if (head == null || n == 0) return head;
        SingleListNode pre = new SingleListNode(-1, head);
        SingleListNode slow = pre;
        SingleListNode fast = head;
        for (int i = n; i > 0; i--) {
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return pre.next;
    }
}
