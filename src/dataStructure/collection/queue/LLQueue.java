package dataStructure.collection.queue;

import dataStructure.collection.listnode.ListNode;

/**
 * @author liyu
 * @date 2020/1/20 15:48
 * @description 基于链表实现队列
 */
public class LLQueue {
    private ListNode frontNode;//represents headNode
    private ListNode rearNode;//represents lastNode

    public LLQueue() {
        this.frontNode = null;
        this.rearNode = null;
    }

    public boolean isEmpty() {
        return frontNode == null;
    }

    public void enQueue(int data) {
        ListNode listNode = new ListNode(data);
        if (rearNode != null) {
            rearNode.setNext(listNode);
        } else {
            rearNode = listNode;
        }
        if (frontNode == null) {
            frontNode = rearNode;
        }
    }

    public int deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("");
        }
        int data = frontNode.getData();
        frontNode = frontNode.getNext();
        return data;
    }
}
