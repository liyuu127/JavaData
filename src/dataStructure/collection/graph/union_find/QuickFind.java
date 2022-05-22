package dataStructure.collection.graph.union_find;

/**
 * @author liyu
 * date 2022/4/25 11:40
 * description quick-find�㷨
 * find O(1)
 * union O(n)
 */
public class QuickFind {
    /**
     * ����id ����λ���㣬ֵΪ������ʶ
     */
    private int[] id;
    /**
     * ��������
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
     * ��ѯp����ķ�����ʶ
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * ��ͨ��������
     */
    public void union(int p, int q) {
        //�Ѿ���ͨ��������
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        //��p�������д���ı�ʶ����Ϊq��
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}
