package algorithm.other;

/**
 * @author liyu
 * date 2020/9/17 11:09
 * description
 * see:{https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/unionfind-suan-fa-xiang-jie}
 */
public class UnionFind {

    /**
     * 基础UF
     */
    class UF {
        // 记录连通分量
        private int count;
        // 节点 x 的节点是 parent[x]
        private int[] parent;

        /**
         * 构造函数，n 为图的节点总数
         */
        public UF(int n) {
            // 一开始互不连通
            this.count = n;
            // 父节点指针初始指向自己
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            // 将两棵树合并为一棵
            parent[rootP] = rootQ;
            // parent[rootQ] = rootP 也一样
            count--; // 两个分量合二为一
        }

        /**
         * 返回某个节点 x 的根节点
         */
        private int find(int x) {
            // 根节点的 parent[x] == x
            while (parent[x] != x)
                x = parent[x];
            return x;
        }

        /**
         * 返回当前的连通分量个数
         */
        public int count() {
            return count;
        }
    }

    /**
     * 平衡优化后的UF
     */
    class UF2 {
        private int count;
        private int[] parent;
        // 新增一个数组记录树的“重量”
        private int[] size;

        public UF2(int n) {
            this.count = n;
            parent = new int[n];
            // 最初每棵树只有一个节点
            // 重量应该初始化 1
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }


        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
//                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
