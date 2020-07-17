package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/17
 */
public class P24SwapNodesinPairs {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        l1 = null;

        ListNode r = new P24SwapNodesinPairs().new Solution().swapPairs(l1);
        while (r != null) {
            System.out.print(r.val + "->");
            r = r.next;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode prev = null;
            ListNode begin = head;
            ListNode end = (begin != null ? begin.next : null);

            if (end == null) {
                return head;
            }
            head = end;

            while (end != null) {
                if (prev != null) {
                    prev.next = end;
                }
                begin.next = end.next;
                end.next = begin;

                prev = begin;
                if (begin.next != null) {
                    begin = begin.next;
                }
                end = begin.next;
            }
            return head;
        }
    }
}
