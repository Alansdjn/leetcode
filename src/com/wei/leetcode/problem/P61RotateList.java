package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/09
 */
public class P61RotateList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // ListNode node5 = new ListNode(5, null);
        // ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(1, node2);
        ListNode node0 = new ListNode(0, node1);
        ListNode r = new P61RotateList().new Solution().rotateRight(node0, 4);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }

    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            int length = length(head);
            if (length == 0) {
                return head;
            }
            k = k % length;
            ListNode curr = head;
            ListNode kPrev = curr;
            while (k > 0) {
                curr = curr.next;
                k--;
            }
            while (curr.next != null) {
                curr = curr.next;
                kPrev = kPrev.next;
            }

            curr.next = head;
            head = kPrev.next;
            kPrev.next = null;
            return head;
        }

        private int length(ListNode head) {
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }
            return length;
        }
    }
}
