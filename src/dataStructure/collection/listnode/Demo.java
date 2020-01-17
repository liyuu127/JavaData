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
//        testListNodeLoop();

        //测试有序链表插入
//         testInsertSortedList();

        //测试链表反转
//        testReverseList();

        //测试查找链表相交结点
//        testIntersectingNode();

        //测试查找链表中间结点，反向打印链表，判断链表长度奇数偶数
//        testMiddleAndReversePrint();

        //测试合并两条有序链表
//        testMergeList();

        //测试成对逆置链表
//        testReversePairList();

        //测试约瑟夫环
        int josephusPosition = getJosephusPosition(5, 5);
        System.out.println("josephusPosition = " + josephusPosition);
    }

    private static void testReversePairList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);
        listNode6.setNext(listNode7);
        listNode7.setNext(listNode8);
        listNode8.setNext(listNode9);
        printListNode(listNode1);
        ListNode listNode = reversePairList(listNode1);
        printListNode(listNode);
        ListNode listNode10 = reversePairList2(listNode);
        printListNode(listNode10);
    }

    private static void testMergeList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        listNode1.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode8);
        listNode8.setNext(listNode9);
        listNode9.setNext(listNode10);
        printListNode(listNode1);

        listNode2.setNext(listNode5);
        listNode5.setNext(listNode6);
        listNode6.setNext(listNode7);
        printListNode(listNode2);

        ListNode listNode = mergeSortedList(listNode1, listNode2);
        printListNode(listNode);
    }

    private static void testMiddleAndReversePrint() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode middleNode = findMiddleNode(listNode1);
        System.out.println("middleNode.getData() = " + middleNode.getData());
        printListNode(listNode1);
        printNodeFromEnd(listNode1);
        boolean evenLength = isEvenLength(listNode1);
        System.out.println("evenLength = " + evenLength);
        listNode4.setNext(new ListNode(5));
        boolean evenLength1 = isEvenLength(listNode1);
        System.out.println("evenLength1 = " + evenLength1);
    }

    private static void testIntersectingNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode6 = new ListNode(6);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode12.setNext(listNode13);
        listNode13.setNext(listNode5);
        listNode5.setNext(listNode6);
        ListNode intersectingNode = findIntersectingNode(listNode1, listNode12);
        System.out.println("intersectingNode.getData() = " + intersectingNode.getData());
    }

    private static void testReverseList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode listNode5 = ReverseList(listNode1);
        printListNode(listNode5);
    }

    private static ListNode testInsertSortedList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode listNode = insertSortedList(listNode1, new ListNode(5));
        System.out.println("listNode.getData() = " + listNode.getData());
        printListNode(listNode);
        return listNode;
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
            System.out.print(cur.getData() + "->");
            cur = cur.getNext();
        }
        System.out.println();
    }

    /**
     * 单项链表插入节点
     *
     * @param headNode     头结点
     * @param nodeToInsert 待插入结点
     * @param position     插入为位置
     * @return 返回头结点
     */
    public ListNode insertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
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
    public boolean doesLinkedListContainsLoop(ListNode headNode) {
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

    /**
     * 在有序链表里插入一个结点
     *
     * @param headNode
     * @param newNode
     * @return
     */
    public ListNode insertSortedList(ListNode headNode, ListNode newNode) {
        if (headNode == null) {
            return newNode;
        }
        ListNode cur = headNode;
        ListNode temp = null;
        while (cur != null && cur.getData() < newNode.getData()) {
            temp = cur;
            cur = cur.getNext();
        }
        //在cur之前插入结点
        newNode.setNext(cur);
        if (temp != null) {
            temp.setNext(newNode);
            return headNode;
        }
        return newNode;
    }

    /**
     * 反转单向链表
     *
     * @param headNode
     * @return
     */
    public ListNode ReverseList(ListNode headNode) {
        ListNode next = null;
        ListNode temp = null;
        while (headNode != null) {
            next = headNode.getNext();
            headNode.setNext(temp);
            temp = headNode;
            headNode = next;
        }
        return temp;
    }

    /**
     * 查找两个链表相交的结点，假设两个链表均无环
     * 时间复杂度O(max(m,n))
     * 空间复杂度O(1)
     *
     * @param L1HeadNode
     * @param L2HeadNode
     */
    public ListNode findIntersectingNode(ListNode L1HeadNode, ListNode L2HeadNode) {
        int l1 = listLength(L1HeadNode);
        int l2 = listLength(L2HeadNode);
        ListNode longList, shortList;
        int d;
        if (l1 < l2) {
            longList = L2HeadNode;
            shortList = L1HeadNode;
            d = l2 - l1;
        } else {
            longList = L1HeadNode;
            shortList = L2HeadNode;
            d = l1 - l2;
        }
        //长链先移动d
        for (int i = 0; i < d; i++) {
            longList = longList.getNext();
        }
        //长短一起移动，直至相遇
        while (longList != null && shortList != null) {
            if (shortList == longList) {
                return shortList;
            }
            shortList = shortList.getNext();
            longList = longList.getNext();
        }
        return null;
    }

    /**
     * 查询链表中间节点，
     *
     * @param headNode
     * @return
     */
    public ListNode findMiddleNode(ListNode headNode) {
        if (headNode == null) {
            return null;
        }
        ListNode slow = headNode, fast = headNode;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    /**
     * 反向打印链表
     * 递归形式
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param headNode
     */
    public void printNodeFromEnd(ListNode headNode) {
        if (headNode == null) {
            return;
        }
        printNodeFromEnd(headNode.getNext());
        System.out.println(headNode.getData());
    }

    /**
     * 判断一个链表的长度是偶数还是奇数
     *
     * @param head
     * @return
     */
    public boolean isEvenLength(ListNode head) {

        ListNode cur = head;
        while (cur != null && cur.getNext() != null) {
            cur = cur.getNext().getNext();
        }
        if (cur == null) {
            return true;
        }
        return false;
    }

    /**
     * 合并两个有序链表为一条
     *
     * @param a
     * @param b
     * @returnh
     */
    public ListNode mergeSortedList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode result;
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(mergeSortedList(a.getNext(), b));
        } else {
            result = b;
            result.setNext(mergeSortedList(b.getNext(), a));
        }
        return result;
    }

    /**
     * 成对逆转列表
     * 1->2->3->4->5 ======>2->1->4->3->5
     * 递归版
     *
     * @param head
     * @return
     */
    public ListNode reversePairList(ListNode head) {
        ListNode temp;
        if (head == null || head.getNext() == null) {
            return head;
        } else {
            temp = head.getNext();
            head.setNext(temp.getNext());
            temp.setNext(head);
            head = temp;
            head.getNext().setNext(reversePairList(head.getNext().getNext()));
            return head;
        }
    }

    /**
     * 成对逆转列表
     * 1->2->3->4->5 ======>2->1->4->3->5
     * 迭代版
     *
     * @param head
     * @return
     */
    public ListNode reversePairList2(ListNode head) {
        ListNode temp1 = null;
        ListNode temp2 = null;
        while (head != null && head.getNext() != null) {
            if (temp1 != null) {
                temp1.getNext().setNext(head.getNext());
            }
            temp1 = head.getNext();
            head.setNext(head.getNext().getNext());
            temp1.setNext(head);
            if (temp2 == null) {
                temp2 = temp1;
            }
            head = head.getNext();
        }
        return temp2;
    }

    /**
     * 将一个循环链表平分为两个，如果节点数为奇数，前一个较大
     *
     * @param head  原链表头结点
     * @param head1 分割后链表头结点1
     * @param head2 分割后链表头结点2 长链
     */
    public void splitList(ListNode head, ListNode head1, ListNode head2) {
        ListNode slow = head, fast = head;
        if (head == null) {
            return;
        }
        if (head.getNext() != head) {//判断链表是否
            head2 = head;
            return;
        }
        //循环链表有奇数个结点时，fast.next将指向head
        if (fast.getNext() != head && fast.getNext().getNext() != head) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        //长度为偶数的情况下，fast指针移动一次
        if (fast.getNext().getNext() == head) {
            fast = fast.getNext();
        }
        //设置前半部分的head指针
        head1 = head;
        //设置后半部分的head指针
        head2 = slow.getNext();
        //把后半部分变成环
        fast.setNext(slow.getNext());
        //把前半部分变成环
        slow.setNext(head);
    }

    /**
     * 约瑟夫环
     * N个人想选出一个领头人，它们排成一个环，沿着环没数到第M个人就从环中排除此人，并从下一个人开始重新计数，请找出最后留在环中的人
     *
     * @param N
     * @param M
     * @return
     */
    public int getJosephusPosition(int N, int M) {
        if (N <= 1) {
            return N;
        }
        //先构建一个环
        ListNode head, temp;
        head = new ListNode(1);
        temp = head;
        for (int i = 2; i <= N; i++) {
            ListNode listNode = new ListNode(i);
            temp.setNext(listNode);
            temp = listNode;
        }
        temp.setNext(head);

        while (N > 1) {
            for (int i = 0; i < M - 1; i++) {
                temp = temp.getNext();
            }
            //除去
            temp.setNext(temp.getNext().getNext());
            temp = temp.getNext();
            N--;
        }
        return temp.getData();
    }

}
