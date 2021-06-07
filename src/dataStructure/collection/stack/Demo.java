package dataStructure.collection.stack;

import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author liyu
 * @date 2020/1/17 16:29
 * @description
 */
@UtilityClass
public class Demo {
    public static void main(String[] args) {

        //测试栈的反转
//        testStackReverse();

//        int[] intPutArray=new int[]{6,1,3,5,3};
//        int[] ints = findingSpans(intPutArray);
//        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

        dequeTest();

    }

    private static void dequeTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(1);
        stack.addLast(2);
        stack.addLast(3);
        stack.addLast(4);
        stack.addLast(5);
        stack.addLast(6);
        stack.addFirst(1);
        stack.addFirst(2);
        stack.addFirst(3);
        stack.addFirst(4);
        stack.addFirst(5);
        stack.addFirst(6);
        stack.addFirst(7);
        System.out.println("stack.peekFirst() = " + stack.peekFirst());
        System.out.println("stack.peekLast() = " + stack.peekLast());
        System.out.println("stack.poll() = " + stack.poll());
        System.out.println("stack.pollFirst() = " + stack.pollFirst());
        System.out.println("stack.pollLast() = " + stack.pollLast());
        System.out.println("stack.remove() = " + stack.remove());
        System.out.println("stack.removeFirst() = " + stack.removeFirst());
        System.out.println("stack.removeLast() = " + stack.removeLast());
    }

    private static void testStackReverse() {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        integers.push(5);
        integers.forEach(System.out::println);
        reverseStack(integers);
        integers.forEach(System.out::println);
    }

    /**
     * 反转栈，递归形式
     *
     * @param stack
     */
    public void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int data) {
        if (stack.empty()) {
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }

    /**
     * 计算跨度
     * 给定数组A,A[i]的跨度S[i]定义为：满足A[j]<=A[j+1]且在A[i]之前的连续元素A[j]的最大个数
     * 迭代法
     * O(n2)
     * O(1)
     *
     * @param intPutArray
     * @return
     */
    public int[] findingSpans(int[] intPutArray) {
        int[] spans = new int[intPutArray.length];
        for (int i = 0; i < intPutArray.length; i++) {
            int index = i - 1;
            int span = 1;
            while (index >= 0 && intPutArray[index] <= intPutArray[index + 1]) {
                span++;
                index--;
            }
            spans[i] = span;
        }
        return spans;
    }



}
