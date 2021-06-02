package algorithm.greedy;

import java.util.Arrays;

public class HuffmanTree {
    int selectStart = 0; //这个变量表示之前“被删除”的最小结点的数量和

    private class HuffmanCode {
        char data; // 存放字符，例如 'C'
        String bit; // 存放编码后的字符串, 例如"111"

        public HuffmanCode(char data, String bit) {
            this.data = data;
            this.bit = bit;
        }
    }

    /**
     * @description: 返回权值排名为rank的结点对象在nodes中的下标（按权值从小到大排）
     */
    private int select(Node[] HT, int range, int rank) {
        Node[] copyNodes = Arrays.copyOf(HT, range);// 将HT[0]~HT[range]拷贝到copyNodes中
        QuickSort.sort(copyNodes); // 对copyNodes进行从小到大的快速排序
        Node target = copyNodes[rank + selectStart]; // 取得“删除”后权值排名为rank的结点对象
        for (int j = 0; j < HT.length; j++) {
            if (target == HT[j]) return j; // 返回该结点对象在数组HT中的下标
        }
        return -1;
    }

    /**
     * @description: 构建赫夫曼树
     */
    public Node[] buildTree(Node[] nodes) {
        int s1, s2, p;
        int n = nodes.length; // 外结点的数量
        int m = 2 * n - 1; // 内结点 + 外结点的总数量
        Node[] HT = new Node[m]; // 存储结点对象的HT数组
        for (int i = 0; i < m; i++) HT[i] = new Node(0); // 初始化HT数组元素
        for (int i = 0; i < n; i++) {
            HT[i].data = nodes[i].data;
            HT[i].weight = nodes[i].weight; //将给定的权值列表赋给外结点对象
        }
        for (int i = n; i < m; i++) {
            s1 = select(HT, i, 0); // 取得HT数组中权值最小的结点对象的下标
            s2 = select(HT, i, 1); // 取得HT数组中权值次小的结点对象的下标
            HT[i].left = s1; // 建立链接
            HT[i].right = s2;
            HT[s1].parent = i;
            HT[s2].parent = i;
            HT[i].weight = HT[s1].weight + HT[s2].weight;// 计算当前外结点的权值
            selectStart += 2; // 这个变量表示之前“被删除”的最小结点的数量和
        }
        return HT; // 将处理后的HT数组返回
    }

    /**
     * @description: 进行赫夫曼编码
     */
    public HuffmanCode[] encode(Node[] nodes) {
        Node[] HT = buildTree(nodes); // 根据输入的nodes数组构造赫夫曼树
        int n = nodes.length;
        HuffmanCode[] HC = new HuffmanCode[n];
        String bit;
        for (int i = 0; i < n; i++) { // 遍历各个叶子结点
            bit = "";
            for (int c = i, f = HT[i].parent; f != 0; c = f, f = HT[f].parent) { // 从叶子结点上溯到根结点
                if (HT[f].left == c) bit = "0" + bit; // 反向编码
                else bit = "1" + bit;
            }
            HC[i] = new HuffmanCode(HT[i].data, bit); // 将字符和对应的编码存储起来
        }
        return HC;
    }

    /**
     * @description: 进行赫夫曼译码
     */
    public String decode(Node[] nodes, String code) {
        String str = "";
        Node[] HT = buildTree(nodes);
        int n = HT.length - 1;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '1') {
                n = HT[n].right;
            } else {
                n = HT[n].left;
            }
            if (HT[n].left == 0) {
                str += HT[n].data;
                n = HT.length - 1;
            }
        }
        return str;
    }

    /**
     * 结点类
     * weight表示权值， data表示外结点存储的字符，data属性在下面的编码/解码中会用到。
     * 而同样因为赫夫曼编码，解码的需求，这里我们使用三叉链实现二叉树，，]
     * 即在left和right属性的基础上，为结点增加了parent属性，目的是能够从叶子结点上溯到根结点，从而实现赫夫曼编码。
     */
    private static class Node {
        char data;
        int weight;
        int left, right, parent;

        public Node(char data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public Node(int weight) {
            this.weight = weight;
        }
    }

    /**
     * 结点排序类
     */
    private static class QuickSort {
        /**
         * @description: 交换两个数组元素
         */
        private static void exchange(Node[] a, int i, int j) {
            Node temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        /**
         * @description: 切分函数
         */
        private static int partition(Node[] a, int low, int high) {
            int i = low, j = high + 1;      // i, j为左右扫描指针
            int pivotkey = a[low].weight;  // pivotkey 为选取的基准元素（头元素）
            while (true) {
                while (a[--j].weight > pivotkey) {
                    if (j == low) break;
                }  // 右游标左移
                while (a[++i].weight < pivotkey) {
                    if (i == high) break;
                }  // 左游标右移
                if (i >= j) break;    // 左右游标相遇时候停止， 所以跳出外部while循环
                else exchange(a, i, j);  // 左右游标未相遇时停止, 交换各自所指元素，循环继续
            }
            exchange(a, low, j); // 基准元素和游标相遇时所指元素交换，为最后一次交换
            return j;  // 一趟排序完成， 返回基准元素位置
        }

        /**
         * @description: 根据给定的权值对数组进行排序
         */
        private static void sort(Node[] a, int low, int high) {
            if (high <= low) {
                return;
            } // 当high == low, 此时已是单元素子数组，自然有序， 故终止递归
            int j = partition(a, low, high);  // 调用partition进行切分
            sort(a, low, j - 1);   // 对上一轮排序(切分)时，基准元素左边的子数组进行递归
            sort(a, j + 1, high); // 对上一轮排序(切分)时，基准元素右边的子数组进行递归
        }

        public static void sort(Node[] a) { //sort函数重载， 只向外暴露一个数组参数
            sort(a, 0, a.length - 1);
        }
    }

    /**
     * @description: buildTree方法的用例
     */
    public static void main(String[] args) {
        Node[] nodes = new Node[4];
        nodes[0] = new Node('A', 7);
        nodes[1] = new Node('B', 5);
        nodes[2] = new Node('C', 2);
        nodes[3] = new Node('D', 4);
        HuffmanTree ht = new HuffmanTree();
        System.out.println(ht.decode(nodes, "010110111"));
    }
}