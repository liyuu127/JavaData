package dataStructure.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用 递归节点实现法/左右链表示法 表示一个二叉树节点
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTreeNode {
    /*
     * 一个二叉树包括 数据、左右孩子 三部分
     */
    private int Data;
    private BinaryTreeNode LeftChild;
    private BinaryTreeNode RightChild;

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public BinaryTreeNode getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        LeftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return RightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        RightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "Data=" + Data +
                ", LeftChild=" + LeftChild +
                ", RightChild=" + RightChild +
                '}';
    }
}
