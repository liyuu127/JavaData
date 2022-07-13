package leetCode.array.general;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author liyu
 * date 2022/7/13 9:22
 * description ������ײ
 * ����һ���������� asteroids����ʾ��ͬһ�е����ǡ�
 * ���������е�ÿһ��Ԫ�أ������ֵ��ʾ���ǵĴ�С��������ʾ���ǵ��ƶ���������ʾ�����ƶ�������ʾ�����ƶ�����ÿһ����������ͬ���ٶ��ƶ���
 * �ҳ���ײ��ʣ�µ��������ǡ���ײ�������������໥��ײ����С�����ǻᱬը������������Ǵ�С��ͬ�����������Ƕ��ᱬը�������ƶ�������ͬ�����ǣ���Զ���ᷢ����ײ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺asteroids = [5,10,-5]
 * �����[5,10]
 * ���ͣ�10 �� -5 ��ײ��ֻʣ�� 10 �� 5 �� 10 ��Զ���ᷢ����ײ��
 * ʾ�� 2��
 * <p>
 * ���룺asteroids = [8,-8]
 * �����[]
 * ���ͣ�8 �� -8 ��ײ�����߶�������ը��
 * ʾ�� 3��
 * ���룺asteroids = [10,2,-5]
 * �����[10]
 * ���ͣ�2 �� -5 ������ײ��ʣ�� -5 ��10 �� -5 ������ײ��ʣ�� 10 ��
 * ��ʾ��
 * <p>
 * 2 <= asteroids.length?<= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/asteroid-collision
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class asteroid_collision {
    public static void main(String[] args) {
        int[] ints = asteroidCollision(new int[]{5, 10, -5});
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] asteroidCollision(int[] asteroids) {
//        Deque<Integer> queue = new ArrayDeque<Integer>();
//        for (int i = 0; i < asteroids.length; i++) {
//
//            if (queue.isEmpty() || !(queue.peek() > 0 && asteroids[i] < 0)) {
//                queue.push(asteroids[i]);
//            } else {
//                queue.push(asteroids[i]);
//                while (queue.size() > 1 && queue.peek() + asteroids[i] <= 0) {
//                    Integer p1 = queue.pop();
//                    Integer p2 = queue.pop();
//
//                    if (p2 > 0 && p1 < 0) {
//                        if(p1 + p2<0 )
//                            queue.push(p1);
//                        else if(p1+p2>0)
//                            queue.push(p2);
//                    }else {
//                        queue.push(p2);
//                        queue.push(p1);
//                        break;
//                    }
//                }
//
//            }
//        }
//        int size = queue.size();
//        int[] cnts = new int[size];
//        for (int i = 0; i < size; i++) {
//            cnts[i] = queue.removeLast();
//        }
//
//
//        return cnts;


        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster �Ƿ����
                if (stack.peek() <= -aster) {  // ջ�����Ǳ�ը
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;

    }
}
