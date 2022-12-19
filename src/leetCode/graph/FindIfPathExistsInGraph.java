package leetCode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * date 2022/12/19 9:14
 * description 1971. 寻找图中是否存在路径
 * 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
 * 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。
 * 示例 1：
 * 输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * 输出：true
 * 解释：存在由顶点 0 到顶点 2 的路径:
 * - 0 → 1 → 2
 * - 0 → 2
 * 示例 2：
 * 输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * 输出：false
 * 解释：不存在由顶点 0 到顶点 5 的路径.
 * 提示：
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * 不存在重复边
 * 不存在指向顶点自身的边
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
