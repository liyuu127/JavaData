package leetCode.other;

/**
 * 字典序的第K小数字
 * 给定整数n和k，返回[1, n]中字典序第k小的数字。
 * 示例 1:
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 * 输入: n = 1, k = 1
 * 输出: 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class k_th_smallest_in_lexicographical_order {
    public static void main(String[] args) {
       int maxInt=Integer.MAX_VALUE;
        System.out.println("maxInt = " + maxInt);
        long l1=maxInt+2L;
        System.out.println("l1 = " + l1);
        long l2=maxInt+2;
        System.out.println("l2 = " + l2);
    }

    public static int findKthNumber(int n, int k) {
        int curr = 1;
        int i = 1;
        while (i < k) {
            int steps = getSteps(curr, n);
            //是否可以跳过子树
            if ((i + steps) < k) {
                i = i + 1 + steps;
                curr++;
                System.out.println("curr = " + curr);
            } else {
                curr = curr * 10;
                System.out.println("curr = " + curr);
                i++;
            }
        }
        return curr;
    }

    public static int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr * 10L;
        long last = curr * 10L + 9;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
    public static int getSteps2(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}