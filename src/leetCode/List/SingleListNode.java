package leetCode.List;

/**
 * @author liyu
 * date 2021/6/2 18:08
 * description µ¥Á´±í
 */ // Definition for singly-linked list.
public class SingleListNode {
    int val;
    SingleListNode next;

    SingleListNode() {
    }

    SingleListNode(int val) {
        this.val = val;
    }

    SingleListNode(int val, SingleListNode next) {
        this.val = val;
        this.next = next;
    }
}
