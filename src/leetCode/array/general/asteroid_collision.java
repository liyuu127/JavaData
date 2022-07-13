package leetCode.array.general;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author liyu
 * date 2022/7/13 9:22
 * description 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * 提示：
 * <p>
 * 2 <= asteroids.length?<= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
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
