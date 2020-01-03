package algorithm.recursion;

/**
 * @author liyu
 * @date 2020/1/3 11:31
 * @description 汉诺塔
 */
public class TowersOfHanoi {
    public static void main(String[] args) {
        int i = towersOfHanoi(10, 'A', 'B', 'C', 0);
        System.out.println("i = " + i);
    }

    public static int towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg, int times) {
        //如果只有一个圆盘，直接移动，次数加一
        if (n == 1) {
            times++;
            System.out.println("move disk from " + fromPeg + "\tto\t" + toPeg);
        } else {
            //利用C做辅助，将A柱最上面的n-1个圆盘移动到C柱
            times = towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg, times);
            //余下的圆盘从A移动到B
            System.out.println("move disk from " + fromPeg + "\tto\t" + toPeg);
            times++;
            //利用A做辅助，将C柱最上面的n-1个圆盘移动到B柱
            times = towersOfHanoi(n - 1, auxPeg, toPeg, fromPeg, times);

        }
        return times;
    }

}
