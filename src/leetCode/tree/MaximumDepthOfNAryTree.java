package leetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N������������
 * ����һ�� N �������ҵ��������ȡ�
 * ��������ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�������
 * N �������밴����������л���ʾ��ÿ���ӽڵ��ɿ�ֵ�ָ�����μ�ʾ����
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumDepthOfNAryTree {


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> children = root.children;
        int maxDepth = 0;
        for (int i = 0; i < children.size(); i++) {
            maxDepth = Math.max(maxDepth(children.get(i)), maxDepth);
        }
        return 1 + maxDepth;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    queue.offer(child);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
