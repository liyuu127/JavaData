package leetCode.array.general;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liyu
 * @date 2020/7/2 8:56
 * @description 有序矩阵中第k小的元素
 * 给定一个?n x n?矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2?。
 * 来源：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 */
@UtilityClass
public class KthSmallestElementInASortedMatrix {


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int i = kthSmallest2(matrix, 8);
        System.out.println("i = " + i);

    }

    /**
     * 优先队列构造大顶堆
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int matrix1 : matrix[i]) {
                queue.add(matrix1);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }

    /**
     * 直接排序 最直接的做法是将这个二维数组另存为为一维数组，并对该一维数组进行排序。最后这个一维数组中的第 k 个数即为答案。
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {

        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];

    }

    /**
     * 归并排序 由题目给出的性质可知，这个矩阵的每一行均为一个有序数组。问题即转化为从这 n 个有序数组中找第 k 大的数，可以想到利用归并排序的做法，
     * 归并到第 k 个数即可停止。一般归并排序是两个数组归并，而本题是 n 个数组归并，所以需要用小根堆维护，以优化时间复杂度。
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];


    }


    /**
     * 二分查找
     * 由题目给出的性质可知，这个矩阵内的元素是从左上到右下递增的（假设矩阵左上角为 matrix[0][0]）
     * 我们知道整个二维数组中matrix[0][0] 为最小值matrix[n?1][n?1] 为最大值，现在我们将其分别记作 l 和 r。
     * 可以发现一个性质：任取一个数 mid 满足 l≤mid≤r，那么矩阵中不大于mid 的数，肯定全部分布在矩阵的左上角。
     * 取mid=8：
     * 我们可以看到，矩阵中大于 mid 的数就和不大于mid 的数分别形成了两个板块，沿着一条锯齿线将这个矩形分开。其中左上角板块的大小即为矩阵中不大于 mid 的数的数量。
     * 读者也可以自己取一些 mid 值，通过画图以加深理解。
     * 我们只要沿着这条锯齿线走一遍即可计算出这两个板块的大小，也自然就统计出了这个矩阵中不大于 midmid 的数的个数了。
     * 走法演示如下，依然取mid=8：
     * 可以这样描述走法：
     * 初始位置在 matrix[n?1][0]（即左下角）；
     * 设当前位置为 matrix[i][j]。若matrix[i][j]≤mid，则将当前所在列的不大于mid 的数的数量（即i+1）累加到答案中，并向右移动，否则向上移动；
     * 不断移动直到走出格子为止。
     * 我们发现这样的走法时间复杂度为 O(n)，即我们可以线性计算对于任意一个 mid，矩阵中有多少数不小于它。这满足了二分答案的性质。
     * 不妨假设答案为 x，那么可以知道 l≤x≤r，这样就确定了二分答案的上下界。
     * 每次对于「猜测」的答案 mid，计算矩阵中有多少数不大于 mid ：
     * 如果数量不多于 k，那么说明最终答案 x 不小于 mid；
     * 如果数量少于 k，那么说明最终答案 x 大于 mid。
     * 这样我们就可以计算出最终的结果 x 了。
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest3(int[][] matrix, int k) {

        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
