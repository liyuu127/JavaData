package leetCode.tree;

/**
 * @author liyu
 * date 2022/8/5 9:35
 * description 在二叉树中增加一行
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * 注意，根节点 root 位于深度 1 。
 * 加法规则如下:
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class add_one_row_to_tree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        addOneRow(node1, 5, 4);
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (root == null) {
            return null;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;


//        if (depth == 1) {
//            TreeNode treeNode = new TreeNode(val);
//            treeNode.left = root;
//            return treeNode;
//        }
//
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.push(root);
//        for (int de = 1; de < depth - 1; de++) {
//            int size = deque.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = deque.poll();
//                if (node.left != null) {
//                    deque.push(node.left);
//                }
//                if (node.right != null) {
//                    deque.push(node.right);
//                }
//            }
//        }
//
//        int size = deque.size();
//        for (
//                int i = size;
//                i > 0; i--) {
//            TreeNode node = deque.poll();
//            node.left = new TreeNode(val, node.left, null);
//            node.right = new TreeNode(val, null, node.right);
//        }
//        return root;

    }


    //Definition for a binary tree node.
    public static class TreeNode {
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
