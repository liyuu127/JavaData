package dataStructure.collection.graph.union_find;

/**
 * @author liyu
 * date 2022/4/25 11:55
 * description quick-union算法
 */
public class QuickUnion {
    /**
     * 分量id 索引位触点，值为同分量中的任意触点
     */
    private int[] id;
    /**
     * 分量个数
     */
    private int count;

    public QuickUnion(int n) {
        this.count = n;
        this.id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 查询根触点
     *
     * @param p
     * @return
     */
    public int find(int p) {
        /**
         * 迭代查询父节点
         */
//        while (id[p] != p) {
//            p = id[p];
//        }
//        return p;
        /**
         * 路径压缩
         */
        if ((id[p] != p)) {
            id[p] = find(id[p]);
        }
        return id[p];
    }


    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        id[p] = qId;
        count--;
    }


}
