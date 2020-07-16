package dataStructure.collection.graph;

/**
 * @author liyu
 * @date 2020/7/16 10:06
 * @description 邻接矩阵表示无向图图
 */
public class GraphAdjacencyMatrix {

    private boolean adjMatrix[][];
    private int vertexCount;

    public GraphAdjacencyMatrix(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjMatrix = new boolean[vertexCount][vertexCount];
    }

    /**
     * 添加边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            adjMatrix[i][j] = false;
            adjMatrix[j][i] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            return adjMatrix[i][j];
        } else {
            return false;
        }
    }
}
