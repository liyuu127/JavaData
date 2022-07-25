package dataStructure.collection.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author liyu
 * date 2022/7/25 9:09
 * description 完全二叉树插入器
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * 实现 CBTInserter 类:
 * CBTInserter(TreeNode root)?使用头节点为?root?的给定树初始化该数据结构；
 * CBTInserter.insert(int v)? 向树中插入一个值为?Node.val == val的新节点?TreeNode。使树保持完全二叉树的状态，并返回插入节点?TreeNode?的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * <p>
 * 提示：
 * <p>
 * 树中节点数量范围为?[1, 1000]?
 * 0 <= Node.val <= 5000
 * root?是完全二叉树
 * 0 <= val <= 5000?
 * 每个测试用例最多调用?insert?和?get_root?操作?104?次
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/complete-binary-tree-inserter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class complete_binary_tree_inserter {
    class CBTInserter {
        Queue<TreeNode> candidate;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.candidate = new ArrayDeque<TreeNode>();
            this.root = root;

            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (!(node.left != null && node.right != null)) {
                    candidate.offer(node);
                }
            }
        }

        public int insert(int val) {
            TreeNode child = new TreeNode(val);
            TreeNode node = candidate.peek();
            int ret = node.val;
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                candidate.poll();
            }
            candidate.offer(child);
            return ret;
        }

        public TreeNode get_root() {
            return root;
        }
    }


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
}
