package dataStructure.collection.stack;

import lombok.experimental.UtilityClass;

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
        testStackReverse();

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

}
