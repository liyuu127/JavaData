package leetCode.tree;

/**
 * @author liyu
 * date 2022/8/30 9:12
 * description 998. �������� II
 * ����� ���壺һ�����������㣺����ÿ���ڵ��ֵ�������������е��κ�����ֵ��
 * ����������ĸ��ڵ� root ��һ������ val ��
 * ���� ֮ǰ������ �������������������� Construct(a) ���̴��б� a��root = Construct(a)���ݹ�ع����ģ�
 * ��� a Ϊ�գ����� null ��
 * ������ a[i] ��Ϊ a �����Ԫ�ء�����һ��ֵΪ a[i] �ĸ��ڵ� root ��
 * root ����������������Ϊ Construct([a[0], a[1], ..., a[i - 1]]) ��
 * root ����������������Ϊ Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) ��
 * ���� root ��
 * ��ע�⣬��Ŀû��ֱ�Ӹ��� a ��ֻ�Ǹ���һ�����ڵ� root = Construct(a) ��
 * ���� b �� a �ĸ���������ĩβ����ֵ val����Ŀ���ݱ�֤ b �е�ֵ������ͬ��
 * ���� Construct(b) ��
 */
public class maximum_binary_tree_ii {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
//
//        if (root == null || root.val < val) {
//            TreeNode treeNode = new TreeNode(val);
//            treeNode.left = root;
//            return treeNode;
//        }
//        root.right = insertIntoMaxTree(root.right, val);
//
//        return root;

        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;


    }
}
