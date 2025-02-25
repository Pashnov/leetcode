package org.axp.medium;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
public class _235_LowestCommonAncestorOfaBinarySearchTree {

    public static void main(String[] args) {
        //       6
        //     2   8
        //    0 4 7 9
        //     3 5
        TreeNode root = new TreeNode(6);

        TreeNode _2 = new TreeNode(2);
        TreeNode _8 = new TreeNode(8);
        root.left = _2; root.right = _8;

        TreeNode _0 = new TreeNode(0);
        TreeNode _4 = new TreeNode(4);
        TreeNode _7 = new TreeNode(7);
        TreeNode _9 = new TreeNode(9);
        _2.left = _0; _2.right = _4; _8.left=_7;_8.right=_9;

        TreeNode _3 = new TreeNode(3);
        TreeNode _5 = new TreeNode(5);
        _4.left=_3; _4.right=_5;

        System.out.println("expected 6, result: " + lowestCommonAncestor(root, _2, _8).val);
        System.out.println("expected 2, result: " + lowestCommonAncestor(root, _2, _4).val);

        root = new TreeNode(2);

        TreeNode _1 = new TreeNode(1);
        root.left = _1;
        System.out.println("expected 2, result: " + lowestCommonAncestor(root, root, _1).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || (p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)) {
            return root;
        } else {
            return lowestCommonAncestor((p.val < root.val || q.val < root.val ? root.left : root.right), p, q);
        }
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (Math.min(p.val, q.val) <= root.val && root.val <= Math.max(p.val, q.val)) {
                return root;
            } else if (Math.max(p.val, q.val) < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int left = Math.min(p.val, q.val);
        int right = Math.max(p.val, q.val);
        TreeNode currentRoot = root;
        while (true) {
            if (left <= currentRoot.val && currentRoot.val <= right) {
                return currentRoot;
            } else if (right < currentRoot.val) {
                currentRoot = currentRoot.left;
            } else {
                currentRoot = currentRoot.right;
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
