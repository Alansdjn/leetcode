package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/25
 */
public class P94BinaryTreeInorderTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = left;

        new P94BinaryTreeInorderTraversal().new Solution().inorderTraversal(root).forEach(ele -> {
            System.out.print(ele + ", ");
        });
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> r = new LinkedList<>();

            if (root == null) {
                return r;
            }

            if (root.left != null) {
                r.addAll(inorderTraversal(root.left));
            }

            r.add(root.val);

            if (root.right != null) {
                r.addAll(inorderTraversal(root.right));
            }

            return r;
        }

    }
}
