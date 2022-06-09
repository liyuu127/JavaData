package dataStructure.collection.tree;

/**
 * https://oi-wiki.org/ds/seg/
 */
public class SegmentTreeLazy {
    private int[] tree;
    private int[] lazy;

    private SegmentTreeLazy(int n) {
        tree = new int[n];
    }

    /**
     * ����
     *
     * @param node ��ǰ�ڵ�
     * @param s    ��
     * @param e    ��
     * @param nums ԭ����
     */
    private void build(int node, int s, int e, int[] nums) {
        if (s == e) {
            tree[node] = nums[s];
            return;
        }
        int m = s + (e - s) / 2;
        build(node * 2, s, m, nums);
        build(node * 2, m + 1, e, nums);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    /**
     * lazy ����
     *
     * @param l    �޸�������߽�
     * @param r    �޸������ұ߽�߽�
     * @param c    ����ֵ
     * @param s
     * @param e
     * @param node
     */
    private void update(int l, int r, int c, int s, int e, int node) {

        if (l <= s && r >= e) {
            tree[node] += (e - s + 1) * c;
            lazy[node] += c;
            return;
        }
        int m = s + ((e - s) >> 1);
        //�Ƿ�������ǣ����򴫵ݵ���һ��
        if (lazy[node] != 0 && s != e) {
            tree[node * 2] += (m - s + 1) * lazy[node];
            lazy[node * 2] = lazy[node];
            tree[node * 2 + 1] += (e - m) * lazy[node];
            lazy[node * 2 + 1] = lazy[node];
            lazy[node] = 0;
        }
        if (l <= m) {
            update(l, r, c, s, m, node * 2);
        }
        if (r > m) {
            update(l, r, c, m + 1, r, node * 2 + 1);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    /**
     * �������
     *
     * @param l
     * @param r
     * @param node
     * @param s
     * @param e
     * @return
     */
    private int range(int l, int r, int node, int s, int e) {

        if (l <= s && r >= e) {
            return tree[node];
        }
        int m = s + ((e - s) >> 1);
        if (lazy[node] != 0 && s != e) {
            tree[node * 2] += (m - s + 1) * lazy[node];
            lazy[node * 2] = lazy[node];
            tree[node * 2 + 1] += (e - m) * lazy[node];
            lazy[node * 2 + 1] = lazy[node];
            lazy[node] = 0;
        }
        int sum = 0;
        if (l <= m) {
            sum += range(l, r, node * 2, s, m);
        }
        if (r > m) {
            sum += range(l, r, node * 2 + 1, m + 1, e);
        }
        return sum;
    }
}
