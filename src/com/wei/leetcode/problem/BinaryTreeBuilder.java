package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/09/04
 */
public class BinaryTreeBuilder {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, null, null, 5};
        TreeNode root = BinaryTreeBuilder.build(nums);

        BinaryTreeTraversal.levelorder(root).forEach(item -> {
            System.out.println(item);
        });
    }

    public static TreeNode build(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        for (int i = 1; i < nums.length; i++) {
            TreeNode curr = queue.poll();
            if (nums[i] != null) {
                curr.left = new TreeNode(nums[i]);
                queue.add(curr.left);
            }
            i++;
            if (i < nums.length && nums[i] != null) {
                curr.right = new TreeNode(nums[i]);
                queue.add(curr.right);
            }
        }

        return root;
    }
}
