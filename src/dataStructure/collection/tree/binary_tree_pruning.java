package dataStructure.collection.tree;

/**
 * @author liyu
 * date 2022/7/21 8:56
 * description 二叉树剪枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class binary_tree_pruning {
    public TreeNode pruneTree(TreeNode root) {
//        if (root == null) return root;
//        boolean l = contain1(root.left);
//        if (!l) {
//            root.left = null;
//        }
//        boolean r = contain1(root.right);
//        if (!r) {
//            root.right = null;
//        }
//        return root;

        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;

    }

    public boolean contain1(TreeNode root) {
        if (root == null) return false;

        boolean l = contain1(root.left);
        if (!l) {
            root.left = null;
        }
        boolean r = contain1(root.right);
        if (!r) {
            root.right = null;
        }
        if (root.val == 0 && l && r) {
            root = null;
            return false;
        }
        return true;

    }

    /**
     * Definition for a binary tree node.
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
