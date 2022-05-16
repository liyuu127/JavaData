package leetCode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liyu
 * date 2022/5/16 9:25
 * description 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 */
public class successor_lcci {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
//        TreeNode prev = null, curr = root;
//        while (!stack.isEmpty() || curr != null) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            if (prev == p) {
//                return curr;
//            }
//            prev = curr;
//            curr = curr.right;
//        }
//        return null;
        TreeNode successor = null;
        //是否有右子树，取右子树最小值
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
