package leetCode.tree;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/7/3 8:46
 * @description 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点?的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 0
 * /   \
 * -3    9
 * /    /
 * -10  5
 * <p>
 * 来源：：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
@UtilityClass
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int nums[]={-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
    }


    //    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 贪心构造
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
