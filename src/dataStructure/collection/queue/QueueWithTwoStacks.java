package dataStructure.collection.queue;

import java.util.Stack;

/**
 * @author liyu
 * @date 2020/1/20 16:11
 * @description 两个栈实现队列
 */

public class QueueWithTwoStacks {
    private Stack stack1;
    private Stack stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void enQueue(int data) {
        stack1.push(data);
    }

    public int deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("");
        }
        if (!stack2.isEmpty()) {
            return (int) stack2.pop();
        } else {
            if (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return (int) stack2.pop();
        }
    }
}
