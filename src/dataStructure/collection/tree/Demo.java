package dataStructure.collection.tree;

import lombok.experimental.UtilityClass;
import sun.misc.Queue;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * @date 2020/1/20 17:25
 * @description 二叉树相关问题
 */
@UtilityClass
public class Demo {
    static int preIndex = 0;

    public static void main(String[] args) throws InterruptedException {

        //测试二叉树的性质
//        testBinaryTree();

        int inOrder[] = {8, 4, 2, 5, 1, 6, 3, 7};
        int preOrder[] = {1, 2, 4, 8, 5, 3, 6, 7};
        BinaryTreeNode binaryTreeNode = buildBinaryTree(inOrder, preOrder, 0, 7);


    }

    private static void testBinaryTree() throws InterruptedException {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        root.setLeftChild(node2);
        root.setRightChild(node3);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);
        node4.setLeftChild(node8);

//        int nodeSizeOfBinaryTree = nodeSizeOfBinaryTree(root);
//        System.out.println("nodeSizeOfBinaryTree = " + nodeSizeOfBinaryTree);
//        int nodeSizeOfBinaryTree2 = nodeSizeOfBinaryTree2(root);
//        System.out.println("nodeSizeOfBinaryTree2 = " + nodeSizeOfBinaryTree2);
        int heightOfBinaryTree = heightOfBinaryTree(root);
        System.out.println("heightOfBinaryTree = " + heightOfBinaryTree);
        BinaryTreeNode deepestNode = getDeepestNode(root);
        System.out.println("deepestNode.getData() = " + deepestNode.getData());
        BinaryTreeNode mirror = mirrorOfBinaryTree(root);
        boolean mirror1 = isMirror(root, mirror);
        System.out.println("mirror1 = " + mirror1);
    }

    /**
     * 递归计算二叉树结点数
     *
     * @param root
     * @return
     */
    public int nodeSizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + nodeSizeOfBinaryTree(root.getLeftChild()) + nodeSizeOfBinaryTree(root.getRightChild());
        }
    }

    /**
     * 层次遍历计算二叉树节点数
     *
     * @param root
     * @return
     * @throws InterruptedException
     */
    public int nodeSizeOfBinaryTree2(BinaryTreeNode root) throws InterruptedException {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<BinaryTreeNode> binaryTreeNodeQueue = new Queue<>();
        binaryTreeNodeQueue.enqueue(root);
        while (!binaryTreeNodeQueue.isEmpty()) {
            BinaryTreeNode temp = binaryTreeNodeQueue.dequeue();
            count++;
            if (temp.getLeftChild() != null) {
                binaryTreeNodeQueue.enqueue(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                binaryTreeNodeQueue.enqueue(temp.getRightChild());
            }
        }
        return count;
    }

    /**
     * 递归方式获取二叉树的高度
     *
     * @param root
     * @return
     */
    public int heightOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfBinaryTree(root.getLeftChild());
        int rightHeight = heightOfBinaryTree(root.getRightChild());
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 获取二叉树最深结点
     *
     * @param root
     * @return
     */
    public BinaryTreeNode getDeepestNode(BinaryTreeNode root) throws InterruptedException {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> queue = new Queue<>();
        BinaryTreeNode temp = null;
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            temp = queue.dequeue();
            if (temp.getLeftChild() != null) {
                queue.enqueue(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) {
                queue.enqueue(temp.getRightChild());
            }
        }
        return temp;
    }

    /**
     * 镜像二叉树
     *
     * @param root
     * @return
     */
    public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        mirrorOfBinaryTree(root.getLeftChild());
        mirrorOfBinaryTree(root.getRightChild());
        BinaryTreeNode temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
        return root;
    }

    /**
     * 判断两棵树是否是镜像
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.getData() != root2.getData()) {
            return false;
        } else {
            return isMirror(root1.getLeftChild(), root2.getRightChild()) && isMirror(root1.getRightChild(), root2.getLeftChild());
        }
    }

    /**
     * 根据中序遍历和前序遍历构造一棵二叉树
     *
     * @param inOrder
     * @param preOrder
     * @param inStart
     * @param inEnd
     * @return
     */
    public static BinaryTreeNode buildBinaryTree(int inOrder[], int preOrder[], int inStart, int inEnd) {

        BinaryTreeNode treeNode = new BinaryTreeNode();
        if (inStart > inEnd || preIndex >= preOrder.length) {
            return null;
        }
        treeNode.setData(preOrder[preIndex]);
        //利用preIndex在前序序列中选择当前的结点
        Integer indexInPreOrder = findIndexInPreOrder(inOrder, preOrder[preIndex]);
        if (indexInPreOrder == null) {
            return null;
        }
        preIndex++;
        if (inStart == inEnd) {
            return treeNode;
        }
        treeNode.setLeftChild(buildBinaryTree(inOrder, preOrder, inStart, indexInPreOrder - 1));
        treeNode.setRightChild(buildBinaryTree(inOrder, preOrder, indexInPreOrder + 1, inEnd));
        return treeNode;
    }

    /**
     * LCA
     * 查找二叉树中结点最接近的公共祖先
     * @param root
     * @param nodeA
     * @param nodeB
     * @return
     */
    public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode nodeA,BinaryTreeNode nodeB) {

        return new BinaryTreeNode();

    }

    /**
     * 返回中序遍历数组的指定元素
     *
     * @param inOrder
     * @param data
     * @return
     */
    private static Integer findIndexInPreOrder(int[] inOrder, int data) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return null;
    }

}
