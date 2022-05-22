package dataStructure.collection.graph.union_find;

/**
 * @author liyu
 * date 2022/4/25 11:40
 * description quick-find算法
 * find O(1)
 * union O(n)
 */
public class QuickFind {
    /**
     * 分量id 索引位触点，值为分量标识
     */
    private int[] id;
    /**
     * 分量个数
     */
    private int count;

    public QuickFind(int n) {
        this.count = n;
        this.id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 查询p触点的分量标识
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * 连通两个触点
     */
    public void union(int p, int q) {
        //已经连通不做处理
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        //将p分量所有触点的标识符置为q的
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}
