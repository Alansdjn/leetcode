package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/09/01
 */
public class P101SymmetricTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            // return isSymmetricIte(root.left, root.right);
            return isSymmetricRec(root);
        }

        private boolean isSymmetricIte(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            return isSymmetricIte(left.left, right.left) && isSymmetricIte(left.right, right.right);
        }

        private boolean isSymmetricRec(TreeNode root) {
            Queue<TreeNode> leftQue = new LinkedList<>();
            leftQue.add(root.left);
            Queue<TreeNode> rightQue = new LinkedList<>();
            rightQue.add(root.right);

            do {
                TreeNode left = leftQue.poll();
                TreeNode right = rightQue.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                leftQue.add(left.left);
                leftQue.add(left.right);
                rightQue.add(right.right);
                rightQue.add(right.left);
            } while (!leftQue.isEmpty() && !rightQue.isEmpty());

            return leftQue.isEmpty() && rightQue.isEmpty();
        }
    }
}
