package leetCode.array.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liyu
 * date 2022/8/25 9:40
 * description 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * 示例 1：
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * 提示：
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr 按 升序 排列
 * -104 <= arr[i], x <= 104
 */
public class find_k_closest_elements {

    public static void main(String[] args) {
        List<Integer> closestElements = findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        System.out.println("closestElements = " + closestElements);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int right = Arrays.binarySearch(arr, x);
        if (right < 0) {
            right = 0;
        }
        if (right > arr.length - 1) {
            right = arr.length - 1;
        }
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;


    }
}
