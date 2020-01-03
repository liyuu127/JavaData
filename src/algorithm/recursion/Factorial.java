package algorithm.recursion;

/**
 * @author liyu
 * @date 2020/1/3 11:08
 * @description ½×³Ë
 */
public class Factorial {
    public static void main(String[] args) {
        int fact = fact(10);
        System.out.println("fact = " + fact);

    }

    /**
     * ¼òµ¥µÄµÝ¹éÊµÏÖ½×³Ë
     *
     * @param n
     * @return
     */
    public static int fact(int n) {
        if (n == 0 | n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
