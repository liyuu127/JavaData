package algorithm.sort;

import java.util.LinkedList;

/**
 * @author liyu
 * date 2021/6/24 11:01
 * description ���������޻�ͼ����������
 */
public class TopologicalSort {

    /**
     * ����̰���㷨�� Kahn�㷨
     *
     * @param graph
     */
    public void topologicalSortByKahn(Graph graph) {
        int v = graph.v;
        LinkedList<Integer>[] adj = graph.adj;
        int[] inDegree = new int[v]; // ͳ��ÿ����������
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
     * ����DFS����������
     *
     * @param graph
     */
    public void topologicalSortByDFS(Graph graph) {
        int v = graph.v;
        LinkedList<Integer>[] adj = graph.adj;
        // �ȹ������ڽӱ���s->t��ʾ��s������t��t����s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // ����ռ�
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // ͨ���ڽӱ��������ڽӱ�
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // ������ȱ���ͼ
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
        } // �Ȱ�vertex�������ɴ�����ж��㶼��ӡ����֮���ٴ�ӡ���Լ� �����ڶ��� vertex ��˵��������������ɴ�����ж��㣬Ҳ����˵���Ȱ������������еĶ�������ˣ�Ȼ��������Լ���
        System.out.print("->" + vertex);
    }

    class Graph {
        private int v; // ����ĸ���
        private LinkedList<Integer> adj[]; // �ڽӱ�

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // s����t����s->t
            adj[s].add(t);
        }
    }

}
