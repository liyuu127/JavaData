package dataStructure.collection.stack;

import dataStructure.collection.listnode.ListNode;

import java.util.EmptyStackException;

/**
 * @author liyu
 * @date 2020/1/17 15:35
 * @description 基于链表实现栈
 */
public class LLStack {
    private ListNode headNode;

    public LLStack() {
    }

    public void Push(int data) {
        if (headNode == null) {
            headNode = new ListNode(data);
        } else {
            ListNode listNode = new ListNode(data);
            listNode.setNext(headNode);
            headNode = listNode;
        }
    }

    public int top() {
        if (headNode == null) {
            throw new EmptyStackException();
        } else {
            return headNode.getData();
        }
    }

    public int pop() {
        if (headNode == null) {
            throw new EmptyStackException();
        } else {
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void deleteStack() {
        headNode = null;
    }
}
