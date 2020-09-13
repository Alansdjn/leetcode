package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/09/08
 */
public class P108ConvertSortedArraytoBinarySearchTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new P108ConvertSortedArraytoBinarySearchTree().new Solution().sortedArrayToBST(nums);
        BinaryTreeTraversal.levelorder(root).forEach(item -> {
            System.out.print(item + ", ");
        });
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            if (nums.length == 1) {
                return new TreeNode(nums[0]);
            }
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
            int middle = (begin + end + 1) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            if (begin < middle) {
                root.left = sortedArrayToBST(nums, begin, middle - 1);
            }
            if (middle < end) {
                root.right = sortedArrayToBST(nums, middle + 1, end);
            }

            return root;
        }
    }
}
