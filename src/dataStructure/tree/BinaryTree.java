package dataStructure.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//二叉树的创建
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTree {

    private BinaryTreeNode mRoot;   //根节点

    public void insertAsLeftChild(BinaryTreeNode child) {
        checkTreeEmpty();
        mRoot.setLeftChild(child);
    }

    public void insertAsRightChild(BinaryTreeNode child) {
        checkTreeEmpty();
        mRoot.setRightChild(child);
    }

    private void checkTreeEmpty() {
        if (mRoot == null) {
            throw new IllegalStateException("Can't insert to a null tree! Did you forget set value for root?");
        }
    }

    //删除某个元素很简单，只需要把自己设为 null。
    //但是为了避免浪费无用的内存，方便 GC 及时回收，我们还需要遍历这个元素的左右子树，挨个设为空
    public void deleteNode(BinaryTreeNode node) {
        checkTreeEmpty();
        if (node == null) {  //递归出口
            return;
        }
        deleteNode(node.getLeftChild());
        deleteNode(node.getRightChild());
        node = null;
    }

    //二叉树的清空其实就是特殊的删除元素–删除根节点
    public void clear() {
        if (mRoot != null) {
            deleteNode(mRoot);
        }
    }

    /**
     * 获取树的高度 ，特殊的获得节点高度
     *
     * @return
     */
    public int getTreeHeight() {
        return getHeight(mRoot);
    }

    /**
     * 获得指定节点的高度
     *
     * @param node
     * @return
     */
    public int getHeight(BinaryTreeNode node) {
        if (node == null) {      //递归出口
            return 0;
        }
        int leftChildHeight = getHeight(node.getLeftChild());
        int rightChildHeight = getHeight(node.getRightChild());

        int max = Math.max(leftChildHeight, rightChildHeight);

        return max + 1; //加上自己本身
    }

    //获得二叉树的节点数，需要遍历所有子树，然后加上总和。
    public int getSize() {
        return getChildSize(mRoot);
    }

    /**
     * 获得指定节点的子节点个数
     *
     * @param node
     * @return
     */
    public int getChildSize(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftChildSize = getChildSize(node.getLeftChild());
        int rightChildSize = getChildSize(node.getRightChild());

        return leftChildSize + rightChildSize + 1;
    }


    /**
     * 获得指定节点的父亲节点
     * @param node
     * @return
     */
    public BinaryTreeNode getParent(BinaryTreeNode node) {
        if (mRoot == null || mRoot == node) {   //如果是空树，或者这个节点就是根节点，返回空
            return null;
        } else {
            return getParent(mRoot, node);  //否则递归查找 父亲节点
        }
    }

    /**
     * 递归对比 节点的孩子节点 与 指定节点 是否一致
     *
     * @param subTree 子二叉树根节点
     * @param node    指定节点
     * @return
     */
    public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
        if (subTree == null) {       //如果子树为空，则没有父亲节点，递归出口 1
            return null;
        }
        //正好这个根节点的左右孩子之一与目标节点一致
        if (subTree.getLeftChild() == node || subTree.getRightChild() == node) {    //递归出口 2
            return subTree;
        }
        //需要遍历这个节点的左右子树
        BinaryTreeNode parent;
        if ((parent = getParent(subTree.getLeftChild(), node)) != null) { //左子树节点就是指定节点，返回
            return parent;
        } else {
            return getParent(subTree.getRightChild(), node);    //从右子树找找看
        }

    }

    /**
     * 先序遍历
     * 先访问根节点
     * 再先序遍历左子树
     * 再先序遍历右子树
     * 退出
     * @param node
     */
    public void iterateFirstOrder(BinaryTreeNode node){
        if (node == null){
            return;
        }
        operate(node);
        iterateFirstOrder(node.getLeftChild());
        iterateFirstOrder(node.getRightChild());
    }

    /**
     * 中序遍历
     * 先中序遍历左子树
     * 再访问根节点
     * 再中序遍历右子树
     * 退出
     * @param node
     */
    public void iterateMediumOrder(BinaryTreeNode node){
        if (node == null){
            return;
        }
        iterateMediumOrder(node.getLeftChild());
        operate(node);
        iterateMediumOrder(node.getRightChild());
    }

    /**
     * 先后序遍历左子树
     * 再后序遍历右子树
     * 最后访问根节点
     * 退出
     * 后序遍历
     * @param node
     */
    public void iterateLastOrder(BinaryTreeNode node){
        if (node == null){
            return;
        }
        iterateLastOrder(node.getLeftChild());
        iterateLastOrder(node.getRightChild());
        operate(node);
    }

    /**
     * 模拟操作
     * @param node
     */
    public void operate(BinaryTreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.getData());
    }

}
