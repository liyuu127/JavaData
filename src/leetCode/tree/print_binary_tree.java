package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * date 2022/8/22 9:02
 * description 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class print_binary_tree {

    public static void main(String[] args) {
        double v = Math.pow(2, 2) - 1;
        System.out.println("v = " + v);
    }

    int h;
    List<List<String>> cnt;

    public List<List<String>> printTree(TreeNode root) {
        h = getHeight(root) - 1;
        int m = h + 1;
        int n = (int) (Math.pow(2, m) - 1);
        cnt = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int i1 = 0; i1 < n; i1++) {
                list.add("");
            }
            cnt.add(list);
        }
        printTree(root, 0, (n - 1) / 2);
        return cnt;

    }

    public void printTree(TreeNode root, int r, int c) {
        if (root == null) return;
        cnt.get(r).set(c, root.val + "");
        if (root.left != null) {
            printTree(root.left, r + 1, c - (int) Math.pow(2, h - r - 1));
        }
        if (root.right != null) {
            printTree(root.right, r + 1, c + (int) Math.pow(2, h - r - 1));
        }
    }

    /**
     * h 从1开始
     *
     * @param root
     * @return
     */
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
