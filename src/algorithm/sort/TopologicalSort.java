package algorithm.sort;

import java.util.LinkedList;

/**
 * @author liyu
 * date 2021/6/24 11:01
 * description 基于有向无环图的拓扑排序
 */
public class TopologicalSort {

    /**
     * 基于贪心算法的 Kahn算法
     *
     * @param graph
     */
    public void topologicalSortByKahn(Graph graph) {
        int v = graph.v;
        LinkedList<Integer>[] adj = graph.adj;
        int[] inDegree = new int[v]; // 统计每个顶点的入度
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); ++j) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }

    /**
     * 基于DFS的拓扑排序
     *
     * @param graph
     */
    public void topologicalSortByDFS(Graph graph) {
        int v = graph.v;
        LinkedList<Integer>[] adj = graph.adj;
        // 先构建逆邻接表，边s->t表示，s依赖于t，t先于s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己 。对于顶点 vertex 来说，我们先输出它可达的所有顶点，也就是说，先把它依赖的所有的顶点输出了，然后再输出自己。
        System.out.print("->" + vertex);
    }

    class Graph {
        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // s先于t，边s->t
            adj[s].add(t);
        }
    }

}
