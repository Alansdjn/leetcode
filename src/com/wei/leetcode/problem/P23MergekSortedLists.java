package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/16
 */
public class P23MergekSortedLists {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l13 = new ListNode(5);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(1, l12);
        l11 = new ListNode(2);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(1, l22);
        l21 = null;

        ListNode l32 = new ListNode(6);
        ListNode l31 = new ListNode(2, l32);
        l31 = new ListNode(-1);
        ListNode[] lists = {l11, l21, l31};

        ListNode r = new P23MergekSortedLists().new Solution().mergeKLists(lists);
        while (r != null) {
            System.out.print(r.val + "->");
            r = r.next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }

            int b = lists.length - 1;
            int a = 0;
            while (a < b) {
                while (a < lists.length && lists[a] != null) {
                    a++;
                }
                while (b >= 0 && lists[b] == null) {
                    b--;
                }
                if (a >= b) {
                    break;
                }
                swap(lists, a, b);
            }
            if (b < 1) {
                return lists[0];
            }

            for (int i = (b + 1) / 2 - 1; i >= 0; i--) {
                adjustHeap(lists, i, b + 1);
            }
            ListNode result = lists[0];
            ListNode curr = result;
            int j = b;
            while (j > 0) {
                if (lists[0].next == null) {
                    swap(lists, 0, j);
                    adjustHeap(lists, 0, j);
                    j--;
                } else {
                    lists[0] = lists[0].next;
                    adjustHeap(lists, 0, j + 1);
                }

                curr.next = lists[0];
                curr = curr.next;
            }
            return result;

        }

        private void adjustHeap(ListNode[] lists, int i, int length) {
            ListNode temp = lists[i];// 先取出当前元素i
            for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {// 从i结点的左子结点开始，也就是2i+1处开始
                if (k + 1 < length && lists[k].val > lists[k + 1].val) {// 如果左子结点大于右子结点，k指向右子结点
                    k++;
                }
                if (lists[k].val < temp.val) {// 如果子节点小于父节点，将子节点值赋给父节点（不用进行交换）
                    lists[i] = lists[k];
                    i = k;
                } else {
                    break;
                }
            }
            lists[i] = temp;
        }

        private void swap(ListNode[] lists, int a, int b) {
            ListNode temp = lists[a];
            lists[a] = lists[b];
            lists[b] = temp;
        }
    }
}
