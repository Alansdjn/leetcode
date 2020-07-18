package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/17
 */
public class P25ReverseNodesinkGroup {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode r = new P25ReverseNodesinkGroup().new Solution().reverseKGroup(l1, 3);
        while (r != null) {
            System.out.print(r.val + "->");
            r = r.next;
        }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode result = null;
            ListNode resultTail = null;
            while (head != null) {
                ListNode currReverseKGroup = null;
                ListNode currReverseKGroupTail = null;
                int i = 0;
                for (; i < k && head != null; i++) {
                    ListNode tmp = head;
                    head = head.next;
                    tmp.next = null;
                    if (currReverseKGroup == null) {
                        currReverseKGroup = tmp;
                        currReverseKGroupTail = tmp;
                    } else {
                        tmp.next = currReverseKGroup;
                        currReverseKGroup = tmp;
                    }
                }

                if (i == k) {
                    if (result == null) {
                        result = currReverseKGroup;
                    } else {
                        resultTail.next = currReverseKGroup;
                    }
                    resultTail = currReverseKGroupTail;
                } else {
                    if (result == null) {
                        result = reverseList(currReverseKGroup);
                    } else {
                        resultTail.next = reverseList(currReverseKGroup);
                    }
                }
            }
            return result;
        }

        public ListNode reverseList(ListNode head) {
            ListNode reverseList = null;
            while (head != null) {
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
                if (reverseList == null) {
                    reverseList = tmp;
                } else {
                    tmp.next = reverseList;
                    reverseList = tmp;
                }
            }
            return reverseList;
        }
    }
}
