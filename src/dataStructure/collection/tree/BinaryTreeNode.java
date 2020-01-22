package dataStructure.collection.tree;

import lombok.Data;

//用 递归节点实现法/左右链表示法 表示一个二叉树节点
@Data
public class BinaryTreeNode {
    /*
     * 一个二叉树包括 数据、左右孩子 三部分
     */
    private int data;
    private BinaryTreeNode LeftChild;
    private BinaryTreeNode RightChild;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode() {
    }

    public String toString() {
        return "BinaryTreeNode{" +
                "Data=" + data +
                ", LeftChild=" + LeftChild +
                ", RightChild=" + RightChild +
                '}';
    }
}
