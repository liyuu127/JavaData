package dataStructure.collection.stack;

/**
 * @author liyu
 * @date 2020/1/17 15:01
 * @description 动态数组实现栈
 */
public class DynArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    static final int initialization_capacity = 1;
    static final double default_expansion_factor = 1.5;

    public DynArrayStack() {
        capacity = initialization_capacity;
        array = new int[capacity];
        top = -1;
    }

    public DynArrayStack(int capacity) {
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
            expansion(default_expansion_factor);
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

    private void expansion(double expansionFactor) {
        int[] newArray = new int[(int) (capacity * expansionFactor)];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity *= expansionFactor;
        array = newArray;
    }
}
