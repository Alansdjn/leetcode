package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/08/29
 */
public class P98ValidateBinarySearchTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(2);
        // TreeNode left = new TreeNode(1);
        // TreeNode right = new TreeNode(3);
        // root.right = right;
        // root.left = left;

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.right = right;
        root.left = left;
        TreeNode rightLeft = new TreeNode(3);
        TreeNode rightRight = new TreeNode(6);
        right.left = rightLeft;
        right.right = rightRight;

        System.out.println(new P98ValidateBinarySearchTree().new Solution().isValidBST(root));
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.val <= leftBSTBiggestKey(node.left)) {
                        return false;
                    }
                    queue.add(node.left);
                }
                if (node.right != null) {
                    if (node.val >= rightBSTSmallestKey(node.right)) {
                        return false;
                    }
                    queue.add(node.right);
                }
            }

            return true;
        }

        private int leftBSTBiggestKey(TreeNode leftSubtree) {
            TreeNode root = leftSubtree;
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }

        private int rightBSTSmallestKey(TreeNode rightSubtree) {
            TreeNode root = rightSubtree;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }
    }
}
