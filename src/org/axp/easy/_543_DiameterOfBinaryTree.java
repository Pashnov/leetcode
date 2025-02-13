package org.axp.easy;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class _543_DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                   new TreeNode(2), null);
        System.out.println("actual:" + diameterOfBinaryTree(root) + ", expected:1");

        root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println("actual:" + diameterOfBinaryTree(root) + ", expected:3");

        root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)), null);
        System.out.println("actual:" + diameterOfBinaryTree(root) + ", expected:2");
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return deepAndLengthOfBinaryTree(root)[1];
    }

    public static int[] deepAndLengthOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return new int[]{0, 0};
        }

        var left = new int[]{0, 0};
        if (root.left != null) {
            left = deepAndLengthOfBinaryTree(root.left);
            left[0] = left[0]+1;
        }
        var right = new int[]{0, 0};
        if (root.right != null) {
            right = deepAndLengthOfBinaryTree(root.right);
            right[0] = right[0]+1;
        }

        return new int[]{
                Math.max(left[0], right[0]), //max deep
                Math.max(left[0]+right[0], Math.max(left[1], right[1])) // length = leftDeep+rightDeep or length
        };
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
