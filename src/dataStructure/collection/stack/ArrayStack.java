package dataStructure.collection.stack;

/**
 * @author liyu
 * @date 2020/1/17 14:11
 * @description 基于简单数组实现栈
 */
public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    static final int initialization_capacity = 1;

    public ArrayStack() {
        capacity = initialization_capacity;
        array = new int[capacity];
        top = -1;
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == capacity - 1;
    }

    public void push(int data) {
        if (isStackFull()) {
            throw new IndexOutOfBoundsException("栈已满");
        }
        array[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空栈");
        }
        return array[top--];
    }

    public void deleteStack() {
        top = -1;
    }

}
