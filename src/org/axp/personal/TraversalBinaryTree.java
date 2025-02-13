package org.axp.personal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2), null);
//        System.out.println("actual:" + dfs(root, new LinkedList<>()) + ", expected:1");

        root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(6, new TreeNode(7), null), null),
                        new TreeNode(5, null,
                                new TreeNode(8, new TreeNode(9), new TreeNode(0)))),
                new TreeNode(3, null, new TreeNode(-3, null, new TreeNode(-4))));
        //     1
        //    2  3
        //   4 5  -3
        //  6   8  -4
        // 7   9 0
        System.out.println("dfs:" + dfs(root, new LinkedList<>()) + " ");
        System.out.println("bfs:" + bfs(root, new LinkedList<>()) + " ");

//        root = new TreeNode(4,
//                new TreeNode(2, new TreeNode(1), new TreeNode(3)), null);
//        System.out.println("actual:" + dfs(root, new LinkedList<>()) + ", expected:2");
    }

    // Depth-First Search
    public static List<Integer> dfs(TreeNode root, List<Integer> out) {
        if (root == null) {
            return out;
        }
        root.visited = true;
        out.add(root.val);
        dfs(root.left, out);
        dfs(root.right, out);
        return out;
    }

    // Breadth-First Search
    public static List<Integer> bfs(TreeNode root, List<Integer> out) {
        if (root == null) {
            return out;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> localQ = queue;
            queue = new LinkedList<>();
            while (!localQ.isEmpty()) {
                TreeNode poll = localQ.poll();
                if (poll == null) {
                    continue;
                }
                out.add(poll.val);
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return out;
    }

    public static class TreeNode {
        boolean visited = false;
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
