package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/26
 */
public class P95UniqueBinarySearchTreesII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<TreeNode> roots = new P95UniqueBinarySearchTreesII().new Solution().generateTrees(4);
        roots.forEach(root -> {
            System.out.println(">>> ");
            new BinaryTreeTraversal().levelorder(root).forEach(ele -> {
                System.out.print(ele + ", ");
            });
            System.out.println();
        });

    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int begin, int end) {
            List<TreeNode> r = new LinkedList<>();
            for (int i = begin; i <= end; i++) {

                if (i == begin && i == end) {
                    TreeNode root = new TreeNode(i);
                    r.add(root);
                    continue;
                }

                List<TreeNode> left = new LinkedList<>();
                List<TreeNode> right = new LinkedList<>();
                if (i > begin) {
                    left.addAll(generateTrees(begin, i - 1));
                }
                if (i < end) {
                    right.addAll(generateTrees(i + 1, end));
                }

                if (left.size() > 0) {
                    for (TreeNode leftRoot : left) {
                        if (right.size() > 0) {
                            for (TreeNode rightRoot : right) {
                                TreeNode root = new TreeNode(i);
                                root.left = leftRoot;
                                root.right = rightRoot;
                                r.add(root);
                            }
                        } else {
                            TreeNode root = new TreeNode(i);
                            root.left = leftRoot;
                            r.add(root);
                        }
                    }
                } else {
                    for (TreeNode rightRoot : right) {
                        TreeNode root = new TreeNode(i);
                        root.right = rightRoot;
                        r.add(root);
                    }
                }
            }
            return r;
        }

    }
}
