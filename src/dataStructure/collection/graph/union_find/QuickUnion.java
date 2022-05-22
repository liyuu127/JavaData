package dataStructure.collection.graph.union_find;

/**
 * @author liyu
 * date 2022/4/25 11:55
 * description quick-union�㷨
 */
public class QuickUnion {
    /**
     * ����id ����λ���㣬ֵΪͬ�����е����ⴥ��
     */
    private int[] id;
    /**
     * ��������
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
     * ��ѯ������
     *
     * @param p
     * @return
     */
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
        id[p] = qId;
        count--;
    }


}
