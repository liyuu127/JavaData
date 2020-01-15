package dataStructure.collection.listnode;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/1/15 10:12
 * @description 链表测试
 */
@UtilityClass
public class Demo {
    public static void main(String[] args) {

        //测试单链表长度遍历
//        testListNodeLength();

        //测试单向链表插入
//        testInsertListNode();

        //测试双向链表插入
//        testDLLInsert();

        //测试单项链表环结点问题
        testListNodeLoop();


    }

    private static void testListNodeLoop() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode2);
        boolean b = doesLinkedListContainsLoop(listNode1);
        System.out.println("b = " + b);
        int beginLoopNode = findBeginLoopNode(listNode1);
        System.out.println("beginLoopNode = " + beginLoopNode);
        int loopLength = findLoopLength(listNode1);
        System.out.println("loopLength = " + loopLength);
    }

    private static void testDLLInsert() {
        DLLNode dllNode1 = new DLLNode(1);
        DLLNode dllNode2 = new DLLNode(2);
        DLLNode dllNode3 = new DLLNode(3);
        DLLNode dllNode4 = new DLLNode(4);
        DLLNode dllNode5 = new DLLNode(5);
        DLLNode dllNode6 = new DLLNode(6);
        DLLInsert(dllNode1, dllNode2, 2);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode3, 3);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode4, 4);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode5, 5);
        printDLLNode(dllNode1, null);
        DLLInsert(dllNode1, dllNode6, 6);
        printDLLNode(dllNode1, null);
    }

    private static void testInsertListNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode listNode = insertInLinkedList(listNode1, new ListNode(7), 3);
        printListNode(listNode);
    }

    private static void testListNodeLength() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        int i = listLength(listNode1);
        System.out.println("i = " + i);
    }

    /**
     * 返回单向链表的长度
     *
     * @param headNode
     * @return 链表长度
     */
    public int listLength(ListNode headNode) {
        int length = 0;
        ListNode cur = headNode;
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    /**
     * 打印单向链表
     *
     * @param headNode
     * @return
     */
    public void printListNode(ListNode headNode) {
        ListNode cur = headNode;
        while (cur != null) {
            System.out.println(cur.getData());
            cur = cur.getNext();
        }
    }

    /**
     * 单项链表插入节点
     *
     * @param headNode     头结点
     * @param nodeToInsert 待插入结点
     * @param position     插入为位置
     * @return 返回头结点
     */
    ListNode insertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) {//链表为空直接插入
            return nodeToInsert;
        }

        int size = listLength(headNode);

        if (position > size + 1 || position < 1) {//越界判定
            System.out.println("error");
            return headNode;
        }

        if (position == 1) {//插入头部节点
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {//插入中间或尾部结点
            ListNode preNode = headNode;
            int count = 1;
            while (count < position - 1) {
                preNode = preNode.getNext();
                count++;
            }
            ListNode nodeNext = preNode.getNext();
            preNode.setNext(nodeToInsert);
            nodeToInsert.setNext(nodeNext);
            return headNode;
        }
    }

    /**
     * 获取双向链表长度
     *
     * @param headNode
     * @return
     */
    public int getDLLLength(DLLNode headNode) {
        int length = 0;
        DLLNode cur = headNode;
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    public DLLNode DLLInsert(DLLNode heaNode, DLLNode nodeToInsert, int position) {
        if (heaNode == null) {
            return nodeToInsert;
        }

        int size = getDLLLength(heaNode);

        if (position > size + 1 || position < 1) {
            throw new IllegalArgumentException("插入位置无效");
        }
        if (position == 1) {//插入头结点
            nodeToInsert.setNext(heaNode);
            heaNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {
            DLLNode cur = heaNode;
            int index = 1;
            while (index < position - 1) {
                cur = cur.getNext();
                index++;
            }
            DLLNode next = cur.getNext();
            cur.setNext(nodeToInsert);
            nodeToInsert.setPrevious(cur);
            if (next != null) {
                nodeToInsert.setNext(next);
                next.setPrevious(nodeToInsert);
            }
            return heaNode;
        }
    }

    /**
     * 打印DLLNode
     *
     * @param headNode
     * @param endNode
     */
    public void printDLLNode(DLLNode headNode, DLLNode endNode) {

        if (headNode != null) {
            DLLNode cur = headNode;
            while (cur != null) {
                System.out.println(cur.getData());
                cur = cur.getNext();
            }
        } else if (endNode != null) {
            DLLNode cur = endNode;
            while (cur != null) {
                System.out.println(cur.getData());
                cur = cur.getPrevious();
            }
        }
    }

    /**
     * 获取单向循环队列的长度
     *
     * @param head
     * @return
     */
    public int circularListLength(CLNode head) {
        int length = 0;
        CLNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.getNext();
            if (cur == head) {
                break;
            }
        }
        return length;
    }

    /**
     * 打印单向循环链表
     *
     * @param head
     */
    public void printCircularList(CLNode head) {
        CLNode cur = head;
        while (cur != null) {
            System.out.println(cur.getData() + "-->");
            cur = cur.getNext();
            if (cur == head) {
                break;
            }
        }
    }

    /**
     * 判断单链表是否有环
     * 基于快慢指针的Floyd环判定算法
     *
     * @param headNode
     * @return
     */
    boolean doesLinkedListContainsLoop(ListNode headNode) {
        if (headNode == null) {
            return false;
        }
        ListNode slow = headNode, fast = headNode;
        while (slow.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断单链表是否有环
     * 无环返回 -1
     * 有环返回环节点位置
     * 快慢节点相遇后，慢结点置于headNode，快慢结点各自以1结点移动，相遇的结点就是环的结点
     *
     * @param headNode
     * @return
     */
    public int findBeginLoopNode(ListNode headNode) {
        if (headNode == null) {
            return -1;
        }
        boolean hasLoop = false;
        ListNode slow = headNode, fast = headNode;
        while (slow.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (hasLoop) {

            slow = headNode;
            int index = 1;
            while (slow != fast) {
                index++;
                slow = slow.getNext();
                fast = fast.getNext();
            }
            return index;
        }
        return -1;
    }

    /**
     * 判断链表是否有环，返回环的长度
     * 相遇后fast再移动一圈
     *
     * @param headNode
     * @return
     */
    public int findLoopLength(ListNode headNode) {
        int loopLength = 0;
        if (headNode == null) {
            return loopLength;
        }
        boolean hasLoop = false;
        ListNode slow = headNode, fast = headNode;
        while (slow.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (hasLoop) {
            fast = fast.getNext();
            loopLength++;
            while (slow != fast) {
                loopLength++;
                fast = fast.getNext();
            }
        }
        return loopLength;
    }


}
