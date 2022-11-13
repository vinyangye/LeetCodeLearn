package mysolution.tree.binarytree.Q104_MaximumDepthOfBinaryTree;

/**
 * @author yeyang
 * @Date 13/11/22
 */
public class Solution {


    class TreeNode {
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

    public int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }

    public int traverse(TreeNode node, int count) {
        if (node == null) {
            return count;
        }

        return Math.max(traverse(node.left, count + 1), traverse(node.right, count + 1));
    }

}
