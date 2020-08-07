package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/07
 */
public class P57InsertInterval {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class Solution {

        public int[][] insert(int[][] intervals, int[] newInterval) {

            if (newInterval.length == 0) {
                return intervals;
            }

            ListNode head = new ListNode(newInterval[0], newInterval[1], null, null);
            int cnt = 1;

            for (int i = 0; i < intervals.length; i++) {
                ListNode curr = head;
                int begin = intervals[i][0];
                int end = intervals[i][1];
                while (curr != null) {
                    int pos = position(curr, begin, end);
                    if (pos == -1) {
                        if (curr.next == null) {
                            curr.next = new ListNode(begin, end, null, curr);
                            cnt++;
                            break;
                        }
                        curr = curr.next;
                    }

                    if (pos == 0) {
                        curr.begin = (curr.begin < begin) ? curr.begin : begin;
                        curr.end = (curr.end > end) ? curr.end : end;

                        ListNode next = curr.next;
                        while (next != null) {
                            if (next.begin > curr.end) {
                                break;
                            }
                            curr.end = (curr.end > next.end ? curr.end : next.end);
                            curr.next = next.next;
                            next = curr.next;
                            if (next != null) {
                                next.prev = curr;
                            }
                            cnt--;
                        }
                        break;
                    }

                    if (pos == 1) {
                        if (curr.prev == null) {
                            curr = new ListNode(begin, end, curr, null);
                            curr.next.prev = curr;
                            head = curr;
                        } else {
                            ListNode node = new ListNode(begin, end, curr, curr.prev);
                            curr.prev.next = node;
                            curr.prev = node;
                        }
                        cnt++;
                        break;
                    }
                }
            }

            int[][] r = new int[cnt][2];
            ListNode curr = head;
            int i = 0;
            while (curr != null) {
                r[i][0] = curr.begin;
                r[i][1] = curr.end;
                i++;
                curr = curr.next;
            }
            return r;

        }

        // -1: node.end < (begin, end)
        // 0: overlap
        // 1: (begin, end) < node.begin
        private int position(ListNode node, int begin, int end) {
            if (node.end < begin) {
                return -1;
            }
            if (node.begin > end) {
                return 1;
            }

            return 0;
        }
    }

    class ListNode {
        int begin;
        int end;

        ListNode next;
        ListNode prev;

        public ListNode(int begin, int end, ListNode next, ListNode prev) {
            this.begin = begin;
            this.end = end;
            this.next = next;
            this.prev = prev;
        }
    }
}
