package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/19
 */
public class P83RemoveDuplicatesfromSortedList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l15 = new ListNode(3);
        ListNode l14 = new ListNode(2, l15);
        ListNode l13 = new ListNode(2, l14);
        ListNode l12 = new ListNode(1, l13);
        ListNode l1 = new ListNode(1, l12);

        ListNode head = new P83RemoveDuplicatesfromSortedList().new Solution().deleteDuplicates(l1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode curr = head.next;
            ListNode tail = head;
            tail.next = null;

            while (curr != null) {
                curr = findNext(curr, tail.val);
                if (curr != null) {
                    tail.next = curr;
                    curr = curr.next;
                    tail = tail.next;
                    tail.next = null;
                }
            }

            return head;
        }

        private ListNode findNext(ListNode head, int currVal) {
            ListNode curr = head;
            while (curr != null && curr.val == currVal) {
                curr = curr.next;
                head.next = null;
                head = curr;
            }
            return head;
        }
    }
}
