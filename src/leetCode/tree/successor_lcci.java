package leetCode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liyu
 * date 2022/5/16 9:25
 * description �����
 * ���һ���㷨���ҳ�������������ָ���ڵ�ġ���һ�����ڵ㣨Ҳ�������̣���
 * ���ָ���ڵ�û�ж�Ӧ�ġ���һ�����ڵ㣬�򷵻�null��
 * ʾ�� 1:
 *
 * ����: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * ���: 2
 * ʾ�� 2:
 *
 * ����: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * ���: null
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
        //�Ƿ�����������ȡ��������Сֵ
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
