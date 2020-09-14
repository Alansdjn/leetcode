package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/09/13
 */
public class P111MinimumDepthofBinaryTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return min(minDepth(root.left, 1), minDepth(root.right, 1));
        }

        private int min(int a, int b) {
            return a > b ? b : a;
        }

        private int minDepth(TreeNode root, int deep) {
            if (root.left == null && root.right == null) {
                return deep + 1;
            }
            if (root.left != null && root.right != null) {
                return min(minDepth(root.left, deep + 1), minDepth(root.right, deep + 1));
            }
            if (root.left != null) {
                return minDepth(root.left, deep + 1);
            }
            // if (root.right != null) {
            return minDepth(root.right, deep + 1);
            // }
        }
    }
}
