package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/11
 */
public class P14LongestCommonPrefix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = {"abab", "aba", ""};
        System.out.println(new P14LongestCommonPrefix().new Solution().longestCommonPrefix(strs));

    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            Node root = new Node();
            root.prefix = "";
            Node tail = root;
            if (strs == null || strs.length == 0 || strs[0].length() == 0) {
                return root.prefix;
            }

            for (int i = 0; i < strs[0].length(); i++) {
                Node node = new Node();
                node.val = strs[0].charAt(i);
                node.prefix = strs[0].substring(0, i + 1);
                tail.next = node;
                tail = node;
            }

            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == 0) {
                    root.next = null;
                    tail = root;
                }
                if (root.next == null) {
                    break;
                }

                Node curr = root.next;
                Node prev = root;
                for (int j = 0; j < strs[i].length(); j++) {

                    if (curr.val == strs[i].charAt(j)) {
                        if (j == strs[i].length() - 1) {
                            curr.next = null;
                            tail = curr;
                            break;
                        } else {
                            curr = curr.next;
                            prev = prev.next;
                            if (curr == null) {
                                break;
                            }
                        }
                    } else {
                        prev.next = null;
                        tail = prev;
                        break;
                    }
                }
            }

            return tail.prefix;
        }
    }

    class Node {
        char val;
        Node next;
        String prefix;
    }
}
