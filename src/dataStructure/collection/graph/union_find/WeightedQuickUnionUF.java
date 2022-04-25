package dataStructure.collection.graph.union_find;

import java.util.Arrays;

/**
 * @author liyu
 * date 2022/4/25 15:40
 * description 加权quick-union 算法的UnionFind
 */
public class WeightedQuickUnionUF {
    /**
     * 父链接数组
     */
    private int[] id;
    /**
     * 各个根节点对应的分量大小
     */
    private int[] sz;
    /**
     * 连通分量的数量
     */
    private int count;

    public WeightedQuickUnionUF(int n) {
        this.count = n;
        this.id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        Arrays.fill(sz, 1);
    }

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
        //如果p是小树则p挂到q上
        if (sz[pId] < sz[qId]) {
            id[pId] = qId;
        } else {
            id[qId] = pId;
        }
        count--;
    }
}
