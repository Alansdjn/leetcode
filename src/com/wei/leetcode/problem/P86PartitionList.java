package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/20
 */
public class P86PartitionList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l16 = new ListNode(2);
        ListNode l15 = new ListNode(5, l16);
        ListNode l14 = new ListNode(2, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(4, l13);
        ListNode l1 = new ListNode(1, l12);

        ListNode r = new P86PartitionList().new Solution().partition(l1, 3);

        while (r != null) {
            System.out.print(r.val + " -> ");
            r = r.next;
        }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }

            if (head.val >= x) {
                ListNode prevNode = findPrev(head, x);
                if (prevNode.next == null) {
                    return head;
                }
                ListNode curr = prevNode.next;
                prevNode.next = curr.next;
                curr.next = head;
                head = curr;
            }

            ListNode tail = head;
            ListNode next = tail.next;
            while (next != null) {
                if (next.val >= x) {
                    ListNode prevNode = findPrev(next, x);
                    if (prevNode.next == null) {
                        return head;
                    }
                    ListNode curr = prevNode.next;
                    prevNode.next = curr.next;

                    curr.next = tail.next;
                    tail.next = curr;
                }
                tail = tail.next;
                next = tail.next;
            }

            return head;
        }

        private ListNode findPrev(ListNode head, int x) {
            ListNode curr = head;
            while (curr.next != null && curr.next.val >= x) {
                curr = curr.next;
            }

            return curr;
        }
    }
}
