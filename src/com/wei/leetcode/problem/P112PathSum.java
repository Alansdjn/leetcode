package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/09/09
 */
public class P112PathSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // int sum = 21;
        // Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        int sum = -1;
        Integer[] nums = {1, -2, -3, 1, 3, -2, null, -1};
//          1
//      -2    -3
//    1   3 -2
// -1

        // int sum = -5;
        // Integer[] nums = {-2, null, -3};
        TreeNode root = BinaryTreeBuilder.build(nums);
        System.out.println(new P112PathSum().new Solution().hasPathSum(root, sum));

    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }

            if (root.val == sum) {
                if (root.left == null && root.right == null) {
                    return true;
                }
            }

            if (root.left != null && hasPathSum(root.left, sum - root.val)) {
                return true;
            }

            if (root.right != null && hasPathSum(root.right, sum - root.val)) {
                return true;
            }

            return false;
        }
    }
}
