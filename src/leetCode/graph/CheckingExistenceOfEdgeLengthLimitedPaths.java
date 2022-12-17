package leetCode.graph;

import java.util.Arrays;

/**
 * @author liyu
 * date 2022/12/14 9:14
 * description 1697. ���߳������Ƶ�·���Ƿ����
 * ����һ�� n ������ɵ�����ͼ�߼� edgeList ������ edgeList[i] = [ui, vi, disi] ��ʾ�� ui �͵� vi ֮����һ������Ϊ disi �ıߡ�
 * ��ע�⣬������֮������� ����һ���� ��
 * ����һ����ѯ����queries ������ queries[j] = [pj, qj, limitj] ����������Ƕ���ÿ����ѯ queries[j] ���ж��Ƿ���ڴ� pj �� qj ��·����
 * ������·���ϵ�ÿһ���߶� �ϸ�С�� limitj ��
 * ���㷵��һ�� �������� answer ������ answer.length == queries.length ���� queries[j] �Ĳ�ѯ���Ϊ true ʱ�� answer �� j ��ֵΪ true ������Ϊ false ��
 * ʾ�� 1��
 * ���룺n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
 * �����[false,true]
 * ���ͣ���ͼΪ�������������ݡ�ע�⵽ 0 �� 1 ֮���������رߣ��ֱ�Ϊ 2 �� 16 ��
 * ���ڵ�һ����ѯ��0 �� 1 ֮��û��С�� 2 �ıߣ��������Ƿ��� false ��
 * ���ڵڶ�����ѯ����һ��·����0 -> 1 -> 2�������߶�С�� 5 �����������ѯ���Ƿ��� true ��
 * ʾ�� 2��
 * ���룺n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]
 * �����[true,false]
 * ���ͣ���ͼΪ�������ݡ�
 * ��ʾ��
 * 2 <= n <= 105
 * 1 <= edgeList.length, queries.length <= 105
 * edgeList[i].length == 3
 * queries[j].length == 3
 * 0 <= ui, vi, pj, qj <= n - 1
 * ui != vi
 * pj != qj
 * 1 <= disi, limitj <= 109
 * ������֮������� ���� �ߡ�
 */
public class CheckingExistenceOfEdgeLengthLimitedPaths {
    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int k = 0;
        int el = edgeList.length;
        int ql = queries.length;
        Integer[] index = new Integer[ql];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> queries[i][2] - queries[j][2]);
        boolean[] ans = new boolean[ql];
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        for (Integer i : index) {

            int limit = queries[i][2];
            while (k < el && edgeList[k][2] < limit) {
                union(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            ans[i] = (find(uf, queries[i][0]) == find(uf, queries[i][1]));
        }
        return ans;

    }

    public static void union(int[] uf, int p, int q) {
        int i = find(uf, p);
        int j = find(uf, q);
        if (i == j) {
            return;
        }
        uf[j] = i;
    }

    public static int find(int[] uf, int p) {
        if (uf[p] == p) {
            return p;
        }
        return uf[p] = find(uf, uf[p]);
    }

    public static void main(String[] args) {
        boolean[] v = distanceLimitedPathsExist(3, new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}}, new int[][]{{0, 1, 2}, {0, 2, 5}});
        System.out.println("v = " + v);
    }
}
