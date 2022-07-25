package dataStructure.collection.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author liyu
 * date 2022/7/25 9:09
 * description ��ȫ������������
 * ��ȫ������ ��ÿһ�㣨�����һ���⣩������ȫ��䣨�����ڵ����ﵽ��󣩵ģ��������еĽڵ㶼�����ܵؼ�������ࡣ
 * ���һ���㷨����һ���½ڵ���뵽һ�������Ķ������У����ڲ���󱣳���������
 * ʵ�� CBTInserter ��:
 * CBTInserter(TreeNode root)?ʹ��ͷ�ڵ�Ϊ?root?�ĸ�������ʼ�������ݽṹ��
 * CBTInserter.insert(int v)? �����в���һ��ֵΪ?Node.val == val���½ڵ�?TreeNode��ʹ��������ȫ��������״̬�������ز���ڵ�?TreeNode?�ĸ��ڵ��ֵ��
 * CBTInserter.get_root() ����������ͷ�ڵ㡣
 * <p>
 * ��ʾ��
 * <p>
 * ���нڵ�������ΧΪ?[1, 1000]?
 * 0 <= Node.val <= 5000
 * root?����ȫ������
 * 0 <= val <= 5000?
 * ÿ����������������?insert?��?get_root?����?104?��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/complete-binary-tree-inserter
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
