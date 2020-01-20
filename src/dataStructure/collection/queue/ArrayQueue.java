package dataStructure.collection.queue;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/1/20 14:44
 * @description 基于简单循环数组实现队列
 */
public class ArrayQueue {
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private int[] array;

    public ArrayQueue(int size) {
        this.capacity = size;
        front = 0;
        rear = 0;
        array = new int[size];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getQueueSize() {
        return size;
    }

    public void enQueue(int data) throws Exception {
        if (isFull()) {
            throw new Exception(" ");
        } else {
            array[rear] = data;
            rear = (rear + 1) % capacity;
            size++;
        }
    }

    public int deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("");
        } else {
            int data = array[front];
            front = (front + 1) % capacity;
            size--;
            return data;
        }
    }

    public void printQueueArray() {
        System.out.println(Arrays.toString(array));
    }
}
