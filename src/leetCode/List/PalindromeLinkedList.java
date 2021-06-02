package leetCode.List;

/**
 * @author liyu
 * date 2021/6/2 15:15
 * description 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用?O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        SingleListNode l1=new SingleListNode(1);
        SingleListNode l2=new SingleListNode(2);
        SingleListNode l3=new SingleListNode(2);
        SingleListNode l4=new SingleListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        boolean palindrome = isPalindrome(l1);
        System.out.println("palindrome = " + palindrome);
    }
    public static boolean isPalindrome(SingleListNode head) {
        if (head == null) return true;

        // 找到前半部分链表的尾节点并反转后半部分链表
        SingleListNode firstHalfEnd = endOfFirstHalf(head);
        SingleListNode secondHalfStart = reverseList(firstHalfEnd.next);

        //对比head pre是否相同
        SingleListNode p1 = head;
        SingleListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }


    private static SingleListNode middleNode(SingleListNode head) {
        SingleListNode slow = head;
        SingleListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    private static SingleListNode reverseList(SingleListNode head) {
        SingleListNode prev = null;
        SingleListNode curr = head;
        while (curr != null) {
            SingleListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static SingleListNode endOfFirstHalf(SingleListNode head) {
        SingleListNode fast = head;
        SingleListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



