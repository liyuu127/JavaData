package leetCode.tree;

/**
 * @author liyu
 * date 2022/8/22 9:02
 * description
 */
public class TreeNode {
         int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
