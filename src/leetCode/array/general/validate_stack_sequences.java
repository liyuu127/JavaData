package leetCode.array.general;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liyu
 * date 2022/8/31 9:49
 * description 946. ��֤ջ����
 * ���� pushed �� popped �������У�ÿ�������е� ֵ�����ظ���
 * ֻ�е����ǿ������������ջ�Ͻ��е����� push �͵��� pop �������еĽ��ʱ��
 * ���� true�����򣬷��� false ��
 * <p>
 * ʾ�� 1��
 * ���룺pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * �����true
 * ���ͣ����ǿ��԰�����˳��ִ�У�
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * ʾ�� 2��
 * ���룺pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * �����false
 * ���ͣ�1 ������ 2 ֮ǰ������
 * <p>
 * ��ʾ��
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * pushed ������Ԫ�� ������ͬ
 * popped.length == pushed.length
 * popped �� pushed ��һ������
 */

public class validate_stack_sequences {
    public static void main(String[] args) {
        boolean b = validateStackSequences(new int[]{0, 2, 1}, new int[]{0, 1, 2});
        System.out.println("b = " + b);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();


    }


}
