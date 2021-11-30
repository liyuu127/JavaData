package leetCode.other;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2021/11/30 9:16
 * description 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 */
@UtilityClass
public class nth_digit {


    public static void main(String[] args) {
        int nthDigit = findNthDigit(2147483647);
        System.out.println("nthDigit = " + nthDigit);

    }

    public int findNthDigit(int n) {
        int i = 1;
        int sl = 0;
        while (true) {
            sl += getL(i);
            if (sl >= n) {
                int c = sl - n;
                int result = i % 10;
                while (c > 0) {
                    if (i / 10 > 0) {
                        i = i / 10;
                    }
                    result = i % 10;
                    c--;

                }
                return result;
            } else if (sl < n) {
                i++;
            }
        }
    }

    public int getL(int n) {
        int i = 1;
        while (n / 10 > 0) {
            n = n / 10;
            i++;
        }
        return i;
    }


    public int findNthDigit1(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

}
