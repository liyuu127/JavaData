package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liyu
 * @date 2020/7/7 8:56
 * @description 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明:?叶子节点是指没有子节点的节点。
 * 示例:?
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2
 * 来源：https://leetcode-cn.com/problems/path-sum
 */
public class PathSum {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * 思路及算法
     * 观察要求我们完成的函数，我们可以归纳出它的功能：询问是否存在从当前节点 root 到叶子节点的路径，满足其路径和为 sum。
     * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
     * 不难发现这满足递归的性质，若当前节点就是叶子节点，那么我们直接判断 sum 是否等于 val 即可（因为路径和已经确定，就是当前节点的值，
     * 我们只需要判断该路径和是否满足条件）。若当前节点不是叶子节点，我们只需要递归地询问它的子节点是否能满足条件即可。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * BFS
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum0(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        Queue<TreeNode> treeNodesQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        treeNodesQueue.add(root);
        sumQueue.add(root.val);

        while (!treeNodesQueue.isEmpty()) {

            TreeNode node = treeNodesQueue.poll();
            Integer nodeSum = sumQueue.poll();

            if (node.left == null && node.right == null) {
                if (sum == nodeSum) {
                    return true;
                }
                continue;
            }

            if (node.left != null) {
                treeNodesQueue.offer(node.left);
                sumQueue.offer(nodeSum + node.left.val);
            }
            if (node.right != null) {
                treeNodesQueue.offer(node.right);
                sumQueue.offer(nodeSum + node.right.val);
            }
        }

        return false;

    }

    public boolean hasPathSum1(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        stack.push(root);
        stackSum.push(root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer tempSum = stackSum.pop();

            if (node.left == null && node.right == null) {
                if (sum == tempSum) {
                    return true;
                }
                continue;
            }

            if(node.left != null){
                stack.push(node.left);
                stackSum.push(node.left.val+tempSum);
            }
            if(node.right != null){
                stack.push(node.right);
                stackSum.push(node.right.val+tempSum);
            }
        }

        return false;

    }


}
