package algorithm.dynamicprogramming;

/**
 * @author liyu
 * @date 2020/1/2 11:11
 * @description 斐波那契（Fibonacci）数列
 */
public class Fibonacci {
    static int n = 0;
    static int[] fib = new int[n];

    public static void main(String[] args) {

        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        System.out.println("fib1(10) = " + fib1(n));
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        System.out.println("fib2(10) = " + fib2(n));
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        System.out.println("fib2(10) = " + fib4(n));
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
    }

    /**
     * 递归方式计算Fibonacci
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);

    }


    /**
     * 动态规划（自底向上）
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];

    }


    /**
     * 动态规划（自顶向下）
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (fib[n] != 0) {
            return fib[n];
        }
        return fib[n] = fib3(n - 1) + fib3(n - 2);

    }

    /**
     * 动态规划 改进
     *
     * @param n
     * @return
     */
    public static int fib4(int n) {
        int a = 0, b = 1, sum = 0, i;
        for (i = 0; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

}
