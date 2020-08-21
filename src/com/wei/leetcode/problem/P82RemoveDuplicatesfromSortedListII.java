package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/19
 */
public class P82RemoveDuplicatesfromSortedListII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l15 = new ListNode(2);
        ListNode l14 = new ListNode(2, l15);
        ListNode l13 = new ListNode(2, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l1 = new ListNode(1, l12);

        ListNode head = new P82RemoveDuplicatesfromSortedListII().new Solution().deleteDuplicates(l1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            head = findNext(head);
            if (head == null || head.next == null) {
                return head;
            }

            
            ListNode tail = head;
            ListNode curr = findNext(tail.next);
            while (curr != null) {
                tail.next = curr;
                tail = tail.next;
                curr = findNext(tail.next);
            }

            tail.next = null;
            return head;
        }

        private ListNode findNext(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            boolean duplicate = false;
            do {
                duplicate = false;
                ListNode curr = head;
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                    duplicate = true;
                }

                if (duplicate) {
                    head = curr.next;
                    curr.next = null;
                }
            } while (duplicate && head != null);

            return head;
        }
    }

}
