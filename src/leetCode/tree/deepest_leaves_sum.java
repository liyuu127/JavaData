package leetCode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liyu
 * date 2022/8/17 9:10
 * description 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/deepest-leaves-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class deepest_leaves_sum {

    // Definition for a binary tree node.
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

    public int deepestLeavesSum(TreeNode root) {
        long sum = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                if (treeNode.left != null) deque.offer(treeNode.left);
                if (treeNode.right != null) deque.offer(treeNode.right);
                sum += treeNode.val;
            }
        }
        return (int)sum;

    }
    int maxLevel = -1;
    int sum = 0;

    public int deepestLeavesSum0(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            sum = node.val;
        } else if (level == maxLevel) {
            sum += node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

}
