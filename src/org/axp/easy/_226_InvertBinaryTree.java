package org.axp.easy;

// https://leetcode.com/problems/invert-binary-tree/description/
public class _226_InvertBinaryTree {

    public static void main(String[] args) {
        
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        var temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //Definition for a binary tree node.
    public static class TreeNode {
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
}
