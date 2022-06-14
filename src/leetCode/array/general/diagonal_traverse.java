package leetCode.array.general;

/**
 * @author liyu
 * date 2022/6/14 14:19
 * description �Խ��߱���
 * ����һ����СΪ m x n �ľ��� mat �����ԶԽ��߱�����˳����һ�����鷵����������е�����Ԫ�ء�
 * ʾ�� 1��
 * ���룺mat = [[1,2,3],[4,5,6],[7,8,9]]
 * �����[1,2,4,7,5,3,6,8,9]
 * ʾ�� 2��
 * ���룺mat = [[1,2],[3,4]]
 * �����[1,2,3,4]
 * ��ʾ��
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/diagonal-traverse
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class diagonal_traverse {


    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[] cnt = new int[n * m];

        int i = 0, j = 0, k = 0;
        boolean up = true;
        while (k < m * n) {
            cnt[k++] = mat[i][j];
            if (up) {
                if (i - 1 < 0 || j + 1 >= n) {
                    up = false;
                    if (j + 1 < n) {
                        j++;
                    } else {
                        i++;
                    }
                }else {
                    i--;
                    j++;
                }


            } else {
                if (j - 1 < 0 || i + 1 >= m) {
                    up = true;
                    if (i + 1 < m) {
                        i++;
                    } else {
                        j++;
                    }
                }else {
                    i++;
                    j--;
                }

            }
        }

        return cnt;

    }
}
