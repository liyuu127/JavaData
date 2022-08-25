package leetCode.array.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liyu
 * date 2022/8/25 9:40
 * description 658. �ҵ� K ����ӽ���Ԫ��
 * ����һ�� ����� ������ arr ���������� k �� x �����������ҵ���� x������֮����С���� k ���������صĽ������Ҫ�ǰ������źõġ�
 * ���� a ������ b ���ӽ� x ��Ҫ���㣺
 * |a - x| < |b - x| ����
 * |a - x| == |b - x| �� a < b
 * ʾ�� 1��
 * ���룺arr = [1,2,3,4,5], k = 4, x = 3
 * �����[1,2,3,4]
 * ʾ�� 2��
 * ���룺arr = [1,2,3,4,5], k = 4, x = -1
 * �����[1,2,3,4]
 * ��ʾ��
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr �� ���� ����
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
