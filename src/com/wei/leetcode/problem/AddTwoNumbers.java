package com.wei.leetcode.problem;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 * @author wei wang
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(3);
		l10.next = l11;
		l11.next = l12;

		ListNode l20 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		l20.next = l21;
		l21.next = l22;
		
		
		System.out.println(new AddTwoNumbers(). new Solution().addTwoNumbers(l10, l20));
	}

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			int carry = 0;
			ListNode result = null;
			ListNode tail = null;
			while (l1 != null || l2 != null || carry == 1) {
				int val = carry;
				if (l1 != null) {
					val += l1.val;
					l1 = l1.next;
				}
				if (l2 != null) {
					val += l2.val;
					l2 = l2.next;
				}

				if (val >= 10) {
					carry = 1;
					val -= 10;
				} else {
					carry = 0;
				}

				if (result == null) {
					result = new ListNode(val);
					tail = result;
				} else {
					tail.next = new ListNode(val);
					tail = tail.next;
				}
			}

			return result;
		}
	}

}
