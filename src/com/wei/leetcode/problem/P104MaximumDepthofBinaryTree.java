package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/09/06
 */
public class P104MaximumDepthofBinaryTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Integer[] nums = {};
        Integer[] nums = {3};
        // Integer[] nums = {3, 9, 20, null, null, 15, 7};
        System.out.println(new P104MaximumDepthofBinaryTree().new Solution().maxDepth(BinaryTreeBuilder.build(nums)));

    }

    class Solution {
        public int maxDepth(TreeNode root) {
            int deep = 0;
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            Queue<TreeNode> nextLevelQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    nextLevelQueue.add(node.left);
                }
                if (node.right != null) {
                    nextLevelQueue.add(node.right);
                }

                if (queue.isEmpty()) {
                    deep++;
                    queue = nextLevelQueue;
                    nextLevelQueue = new LinkedList<>();;
                }
            }

            return deep;
        }
    }
}
