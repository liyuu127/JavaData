package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * date 2022/8/22 9:02
 * description ���������
 * ����һ�ö������ĸ��ڵ� root �����㹹��һ���±�� 0 ��ʼ����СΪ m x n ���ַ������� res �����Ա�ʾ���� ��ʽ������ ������˸�ʽ�����־�����Ҫ��ѭ���¹���
 * <p>
 * ���� �߶� Ϊ height ����������� m Ӧ�õ��� height + 1 ��
 * ��������� n Ӧ�õ��� 2height+1 - 1 ��
 * ���ڵ� ��Ҫ������ ���� �� ���м� ����Ӧλ��Ϊ res[0][(n-1)/2] ��
 * ���ڷ����ھ����е�ÿ���ڵ㣬���Ӧλ��Ϊ res[r][c] ���������ӽڵ������ res[r+1][c-2height-r-1] �����ӽڵ������ res[r+1][c+2height-r-1] ��
 * ������һ���̣�ֱ�����е����нڵ㶼���Ʒ��á�
 * ����յ�Ԫ��Ӧ�ð������ַ��� "" ��
 * ���ع���õ��ľ��� res ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/print-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class print_binary_tree {

    public static void main(String[] args) {
        double v = Math.pow(2, 2) - 1;
        System.out.println("v = " + v);
    }

    int h;
    List<List<String>> cnt;

    public List<List<String>> printTree(TreeNode root) {
        h = getHeight(root) - 1;
        int m = h + 1;
        int n = (int) (Math.pow(2, m) - 1);
        cnt = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int i1 = 0; i1 < n; i1++) {
                list.add("");
            }
            cnt.add(list);
        }
        printTree(root, 0, (n - 1) / 2);
        return cnt;

    }

    public void printTree(TreeNode root, int r, int c) {
        if (root == null) return;
        cnt.get(r).set(c, root.val + "");
        if (root.left != null) {
            printTree(root.left, r + 1, c - (int) Math.pow(2, h - r - 1));
        }
        if (root.right != null) {
            printTree(root.right, r + 1, c + (int) Math.pow(2, h - r - 1));
        }
    }

    /**
     * h ��1��ʼ
     *
     * @param root
     * @return
     */
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
