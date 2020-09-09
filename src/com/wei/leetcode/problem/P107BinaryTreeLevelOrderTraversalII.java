package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/09/07
 */
public class P107BinaryTreeLevelOrderTraversalII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> r = new LinkedList<>();

            if (root == null) {
                return r;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int currLevel = 1;
            int nextLevel = 0;
            List<Integer> currR = null;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                currLevel--;
                if (currR == null) {
                    currR = new LinkedList<>();
                }
                currR.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    nextLevel++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLevel++;
                }

                if (currLevel == 0) {
                    r.add(0, currR);
                    currR = null;
                    currLevel = nextLevel;
                    nextLevel = 0;
                }
            }

            return r;
        }
    }
}
