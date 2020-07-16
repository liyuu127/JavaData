package dataStructure.collection.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author liyu
 * @date 2020/7/16 10:06
 * @description 邻接表表示图
 */
public class GraphAdjacencyList {

    private ArrayList<Integer> vertices;
    private LinkedList[] edges;
    private int vertexCount;

    public GraphAdjacencyList(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertices = new ArrayList<>();
        this.edges = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            vertices.add(i);
            edges[i] = new LinkedList();
            edges[i].addFirst(i);
        }

    }

    /**
     * 添加边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {
        edges[i].addLast(j);
    }

    public void removeEdge(int i, int j) {
        edges[i].remove(Integer.valueOf(j));
    }

    public boolean isEdge(int i, int j) {
        return edges[i].contains(j);
    }
}
