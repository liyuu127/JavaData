package leetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * date 2022/12/19 9:14
 * description 1971. Ѱ��ͼ���Ƿ����·��
 * ��һ������ n ������� ˫�� ͼ������ÿ�������Ǵ� 0 �� n - 1������ 0 �� n - 1����ͼ�еı���һ����ά�������� edges ��ʾ������ edges[i] = [ui, vi] ��ʾ���� ui �Ͷ��� vi ֮���˫��ߡ� ÿ��������� ���һ�� �����ӣ�����û�ж�����������������ıߡ�
 * ����ȷ���Ƿ���ڴӶ��� source ��ʼ�������� destination ������ ��Ч·�� ��
 * �������� edges ������ n��source �� destination������� source �� destination ���� ��Ч·�� ���򷵻� true�����򷵻� false ��
 * ʾ�� 1��
 * ���룺n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * �����true
 * ���ͣ������ɶ��� 0 ������ 2 ��·��:
 * - 0 �� 1 �� 2
 * - 0 �� 2
 * ʾ�� 2��
 * ���룺n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * �����false
 * ���ͣ��������ɶ��� 0 ������ 5 ��·��.
 * ��ʾ��
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * �������ظ���
 * ������ָ�򶥵�����ı�
 */
public class FindIfPathExistsInGraph {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                lists[i].add(j);
                lists[j].add(i);
            }
        }

        boolean[] v = new boolean[n];
        ArrayDeque<Integer> de = new ArrayDeque<>();
        de.push(source);
        v[source] = true;
        while (!de.isEmpty()) {
            Integer node = de.poll();
            if (node == destination) {
                break;
            }
            for (Integer i : lists[node]) {
                if (!v[i]) {
                    de.push(i);
                    v[i] = true;
                }
            }
        }
        return v[destination];

    }

    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                lists[i].add(j);
                lists[j].add(i);
            }
        }
        return dfs(source, destination, lists, new boolean[n]);

    }

    public boolean dfs(int source, int destination, List<Integer>[] lists, boolean[] v) {
        if (source == destination) {
            return true;
        }
        for (Integer i : lists[source]) {
            if (!v[i]) {
                v[i] = true;
                if (dfs(i, destination, lists, v)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
    }
}
