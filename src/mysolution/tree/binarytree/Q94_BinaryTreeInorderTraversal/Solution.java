package mysolution.tree.binarytree.Q94_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    List<Integer> list = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        traverse(root);
        return list;

    }

    public void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }

    public List<Integer> inorderTraversalInteration(TreeNode root) {

        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;

    }



}
