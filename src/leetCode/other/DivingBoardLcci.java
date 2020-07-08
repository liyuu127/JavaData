package leetCode.other;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * @author liyu
 * @date 2020/7/8 9:28
 * @description 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * 示例：
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 来源：https://leetcode-cn.com/problems/diving-board-lcci
 */
@UtilityClass
public class DivingBoardLcci {


    public static void main(String[] args) {
        int[] ints = divingBoard(1, 1, 0);
        String s = Arrays.toString(ints);
        System.out.println("s = " + s);
    }

    public int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] res = new int[k + 1];
        for (int shorterNumber = k; shorterNumber >= 0; shorterNumber--) {
            int longerNumber = k - shorterNumber;
            res[longerNumber] = shorter * shorterNumber + longer * longerNumber;

        }
        return res;
    }
}
