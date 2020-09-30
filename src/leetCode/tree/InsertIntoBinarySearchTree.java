package leetCode.tree;

/**
 * @author liyu
 * date 2020/9/30 15:04
 * description 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。
 * 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 * 你可以返回任意有效的结果。
 * 例如,
 * 给定二叉搜索树:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * 或者这个树也是有效的:
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 */
public class InsertIntoBinarySearchTree {

    class TreeNode {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp != null) {
            if (val < temp.val) {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
}
