package com.wei.leetcode.problem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/09/04
 */
public class P103BinaryTreeZigzagLevelOrderTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
         Integer[] nums = {1, 2, 3, 4, null, null, 5};
        //Integer[] nums = {3, 9, 20, null, null, 15, 7};
        new P103BinaryTreeZigzagLevelOrderTraversal().new Solution().zigzagLevelOrder(BinaryTreeBuilder.build(nums))
            .forEach(item -> {
                System.out.println();
                item.forEach(ele -> {
                    System.out.print(ele + ", ");
                });
            });;

    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> r = new LinkedList<>();

            if (root == null) {
                return r;
            }

            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            Deque<TreeNode> nextLevelDeque = new LinkedList<>();
            int currLevelNodeCnt = 1;
            List<Integer> currR = new LinkedList<>();
            boolean toRight = true;
            while (!deque.isEmpty()) {
                TreeNode node = null;
                if (toRight) {
                    node = deque.pollFirst();
                } else {
                    node = deque.pollLast();
                }

                currLevelNodeCnt--;
                currR.add(node.val);
                if (toRight) {
                    if (node.left != null) {
                        nextLevelDeque.addLast(node.left);
                    }
                    if (node.right != null) {
                        nextLevelDeque.addLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevelDeque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        nextLevelDeque.addFirst(node.left);
                    }
                }

                if (currLevelNodeCnt == 0) {
                    r.add(currR);
                    currR = new LinkedList<>();
                    currLevelNodeCnt = nextLevelDeque.size();
                    toRight = !toRight;
                    deque = nextLevelDeque;
                    nextLevelDeque = new LinkedList<>();;
                }
            }

            return r;
        }

    }
}
