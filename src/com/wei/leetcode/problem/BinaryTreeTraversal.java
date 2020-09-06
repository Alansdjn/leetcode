package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/08/28
 */
public class BinaryTreeTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> r = new LinkedList<>();

        if (root == null) {
            return r;
        }

        r.add(root.val);

        if (root.left != null) {
            r.addAll(inorder(root.left));
        }

        if (root.right != null) {
            r.addAll(inorder(root.right));
        }

        return r;

    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> r = new LinkedList<>();

        if (root == null) {
            return r;
        }

        if (root.left != null) {
            r.addAll(inorder(root.left));
        }

        r.add(root.val);

        if (root.right != null) {
            r.addAll(inorder(root.right));
        }

        return r;
    }

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> r = new LinkedList<>();

        if (root == null) {
            return r;
        }

        if (root.left != null) {
            r.addAll(inorder(root.left));
        }

        if (root.right != null) {
            r.addAll(inorder(root.right));
        }

        r.add(root.val);

        return r;

    }

    public static List<Integer> levelorder(TreeNode root) {
        List<Integer> r = new LinkedList<>();

        if (root == null) {
            return r;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            r.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return r;

    }

}
