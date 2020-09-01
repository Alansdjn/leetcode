package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
            List<TreeNode> nextLevel = new LinkedList<>();
            nextLevel.add(root);
            return isSymmetric(nextLevel);
        }

        private boolean isSymmetric(List<TreeNode> levelNodes) {

            Stack<TreeNode> stack = new Stack<>();
            List<TreeNode> nextLevel = new LinkedList<>();

            boolean allNull = true;
            int i = 0;
            for (; i < levelNodes.size() / 2; i++) {
                TreeNode curr = levelNodes.get(i);
                stack.push(curr);
                addNextLevelNodes(nextLevel, curr);
                if (allNull) {
                    allNull = curr != null && (curr.left != null || curr.right != null);
                }
            }
            if (levelNodes.size() % 2 == 1) {
                TreeNode curr = levelNodes.get(i++);
                addNextLevelNodes(nextLevel, curr);
                if (allNull) {
                    allNull = curr != null && (curr.left != null || curr.right != null);
                }
            }
            for (; i < levelNodes.size(); i++) {
                TreeNode curr = levelNodes.get(i);
                TreeNode stackCurr = stack.pop();
                if (curr != stackCurr) {
                    return false;
                }
                addNextLevelNodes(nextLevel, curr);
                if (allNull) {
                    allNull = curr != null && (curr.left != null || curr.right != null);
                }
            }

            return allNull ? true : isSymmetric(levelNodes);
        }

        private void addNextLevelNodes(List<TreeNode> nextLevel, TreeNode curr) {
            if (curr == null) {
                nextLevel.add(null);
                nextLevel.add(null);
            } else {
                nextLevel.add(curr.left);
                nextLevel.add(curr.right);
            }
        }
    }
}
