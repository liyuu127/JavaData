package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ż��
 * ���һ�ö���������������������������Գ�Ϊ ��ż�� ��
 * ���������ڵ����ڲ��±�Ϊ 0 �������ӽڵ����ڲ��±�Ϊ 1 ��������ڵ����ڲ��±�Ϊ 2 ���������ơ�
 * ż���±� ���ϵ����нڵ��ֵ���� �� �����������Ұ�˳�� �ϸ����
 * �����±� ���ϵ����нڵ��ֵ���� ż �����������Ұ�˳�� �ϸ�ݼ�
 * ����������ĸ��ڵ㣬���������Ϊ ��ż�� ���򷵻� true �����򷵻� false ��
 * <p>
 * ���룺root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * �����true
 * ���ͣ�ÿһ��Ľڵ�ֵ�ֱ��ǣ�
 * 0 �㣺[1]
 * 1 �㣺[10,4]
 * 2 �㣺[3,7,9]
 * 3 �㣺[12,8,6,2]
 * ���� 0 ��� 2 ���ϵĽڵ�ֵ�����������ϸ�������� 1 ��� 3 ���ϵĽڵ�ֵ����ż�����ϸ�ݼ����������һ����ż����
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/even-odd-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class even_odd_tree {
    /**
     * Definition for a binary tree node.
     */
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

    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = -1;
        while (!queue.isEmpty()) {
            level++;
            int evenPreNum = Integer.MAX_VALUE;
            int oddPreNum = Integer.MIN_VALUE;
            Queue<TreeNode> queue2 = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) queue2.offer(node.left);
                if (node.right != null) queue2.offer(node.right);
                if (level % 2 == 0) {
                    if (node.val % 2 == 1 && node.val > oddPreNum) {
                        oddPreNum = node.val;
                    } else {
                        return false;
                    }
                } else {
                    if (node.val % 2 == 0 && node.val < evenPreNum) {
                        evenPreNum = node.val;
                    } else {
                        return false;
                    }
                }
            }
            queue = queue2;
        }
        return true;
    }
}
