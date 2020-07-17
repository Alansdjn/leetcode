package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/16
 */
public class P19RemoveNthNodeFromEndofList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode tail = head;
            ListNode prevDel = null;
            int i = 1;
            while (i < n && tail.next != null) {
                tail = tail.next;
                i++;
            }
            if (i < n) {
                return head;
            }
            if (tail.next == null) {
                return head.next;
            }

            tail = tail.next;
            prevDel = head;
            while (tail.next != null) {
                tail = tail.next;
                prevDel = prevDel.next;
            }
            prevDel.next = prevDel.next.next;

            return head;
        }
    }
}
