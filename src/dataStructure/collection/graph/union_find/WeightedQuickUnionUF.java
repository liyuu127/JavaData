package dataStructure.collection.graph.union_find;

import java.util.Arrays;

/**
 * @author liyu
 * date 2022/4/25 15:40
 * description ��Ȩquick-union �㷨��UnionFind
 */
public class WeightedQuickUnionUF {
    /**
     * ����������
     */
    private int[] id;
    /**
     * �������ڵ��Ӧ�ķ�����С
     */
    private int[] sz;
    /**
     * ��ͨ����������
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
         * ������ѯ���ڵ�
         */
//        while (id[p] != p) {
//            p = id[p];
//        }
//        return p;
        /**
         * ·��ѹ��
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
        //���p��С����p�ҵ�q��
        if (sz[pId] < sz[qId]) {
            id[pId] = qId;
        } else {
            id[qId] = pId;
        }
        count--;
    }
}
