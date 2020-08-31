package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/08/30
 */
public class P100SameTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        //TreeNode pLeft = new TreeNode(2);
        TreeNode pRight = new TreeNode(2);
        TreeNode pRightLeft = new TreeNode(3);
        //p.left = pLeft;
        p.right = pRight;
        pRight.left = pRightLeft;

        TreeNode q = new TreeNode(1);
        //TreeNode qLeft = new TreeNode(1);
        TreeNode qRight = new TreeNode(2);
        TreeNode qRightLeft = new TreeNode(3);
        //q.left = qLeft;
        q.right = qRight;
        qRight.left = qRightLeft;

        System.out.println(new P100SameTree().new Solution().isSameTree(p, q));

    }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null && q != null) {
                return false;
            }
            if (p != null && q == null) {
                return false;
            }

            Queue<TreeNode> queueP = new LinkedList<>();
            queueP.add(p);
            Queue<TreeNode> queueQ = new LinkedList<>();
            queueQ.add(q);
            while (!queueP.isEmpty()) {
                if (queueQ.isEmpty()) {
                    return false;
                }

                TreeNode pNode = queueP.poll();
                TreeNode qNode = queueQ.poll();
                if (pNode.val != qNode.val) {
                    return false;
                }

                if (pNode.left != null) {
                    if (qNode.left == null) {
                        return false;
                    }
                    queueP.add(pNode.left);
                    queueQ.add(qNode.left);
                } else {
                    if (qNode.left != null) {
                        return false;
                    }
                }

                if (pNode.right != null) {
                    if (qNode.right == null) {
                        return false;
                    }
                    queueP.add(pNode.right);
                    queueQ.add(qNode.right);
                } else {
                    if (qNode.right != null) {
                        return false;
                    }
                }
            }

            if (!queueQ.isEmpty()) {
                return false;
            }

            return true;
        }
    }
}
