package leetCode.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyu
 * @date 2019/11/13 17:39
 * @description 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 */
public class YangHuiTriangleII {
    public static void main(String[] args) {
        List<Integer> row = getRow(5);
        System.out.println("row = " + row);
    }
    public static List<Integer> getRow(int rowIndex) {

        Integer[] result = new Integer[rowIndex+1];

        Arrays.fill(result, 0);


        result[0] = 1;
        for(int i = 1; i<result.length; i++) {
            for(int j=i;j>0;j--) {
                result[j] = result[j] + result[j-1];
            }
            System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        }

        return Arrays.asList(result);
    }
}
