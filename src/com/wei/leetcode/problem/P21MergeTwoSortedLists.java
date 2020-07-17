package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/16
 */
public class P21MergeTwoSortedLists {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2, l13);
        ListNode l1 = new ListNode(9, l12);
        l1 = null;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3, l23);
        ListNode l2 = new ListNode(0, l22);
        l2 = null;

        ListNode result = new P21MergeTwoSortedLists().new Solution().mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = null;
            ListNode curr = null;
            ListNode min = null;
            boolean fastBreak = false;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 == null) {
                    min = l1;
                    fastBreak = true;
                } else if (l1 == null && l2 != null) {
                    min = l2;
                    fastBreak = true;
                } else {
                    if (l1.val <= l2.val) {
                        min = l1;
                        l1 = l1.next;
                    } else {
                        min = l2;
                        l2 = l2.next;
                    }
                }

                if (result == null) {
                    curr = min;
                    result = curr;
                } else {
                    curr.next = min;
                    curr = curr.next;
                }

                if (fastBreak) {
                    break;
                }
            }
            return result;
        }
    }
}
