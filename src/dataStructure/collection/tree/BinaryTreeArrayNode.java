package dataStructure.collection.tree;

import lombok.Data;

//用 数组下标表示法 表示一个节点
@Data
public class BinaryTreeArrayNode {
    /**
     * 数组实现，保存的不是 左右子树的引用，而是数组下标
     */
    private int mData;
    private int mLeftChild;
    private int mRightChild;

}
