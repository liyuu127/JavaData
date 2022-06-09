package dataStructure.collection.tree;

/**
 * https://oi-wiki.org/ds/seg/
 */
public class SegmentTree {
    private int[] segmentTree;

    private SegmentTree(int n) {
        segmentTree = new int[n];
    }

    /**
     * 建树
     *
     * @param node 当前节点
     * @param s    左
     * @param e    右
     * @param nums 原数组
     */
    private void build(int node, int s, int e, int[] nums) {
        if (s == e) {
            segmentTree[node] = nums[s];
            return;
        }
        int m = s + (e - s) / 2;
        build(node * 2, s, m, nums);
        build(node * 2, m + 1, e, nums);
        segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
    }

    /**
     * 单点更新
     * @param index
     * @param val
     * @param node
     * @param s
     * @param e
     */
    private void update(int index, int val, int node, int s, int e) {
        if (s == e) {
            segmentTree[node] = val;
            return;
        }
        int m = s + (e - s) / 2;
        if (index <= m) {
            update(index, val, node * 2, s, m);
        } else {
            update(index, val, node * 2 + 1, m + 1, e);
        }
        segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
    }

    /**
     * 范围查询
     *
     * @param left
     * @param right
     * @param node
     * @param s
     * @param e
     * @return
     */
    private int range(int left, int right, int node, int s, int e) {
        if (left == s && right == e) {
            return segmentTree[node];
        }
        int m = s + (e - s) / 2;
        if (right <= m) {
            return range(left, right, node * 2, s, m);
        } else if (left > m) {
            return range(left, right, node * 2 + 1, m + 1, e);
        } else {
            return range(left, m, node * 2, s, m) + range(m + 1, right, node * 2 + 1, m + 1, e);
        }
    }
}
