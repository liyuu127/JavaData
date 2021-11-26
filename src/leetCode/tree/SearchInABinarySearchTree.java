package leetCode.tree;

/**
 * @author liyu
 * date 2021/11/26 9:19
 * description �����������е�����
 * ����������������BST���ĸ��ڵ��һ��ֵ�� ����Ҫ��BST���ҵ��ڵ�ֵ���ڸ���ֵ�Ľڵ㡣 �����Ըýڵ�Ϊ���������� ����ڵ㲻���ڣ��򷵻� NULL��
 * <p>
 * ���磬
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    //     Definition for a binary tree node.
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
