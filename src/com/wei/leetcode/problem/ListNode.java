package com.wei.leetcode.problem;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val);
		ListNode node = next;
		while (node != null) {
			sb.append(node.val);
			node = node.next;
		}

		return sb.reverse().toString();
	}

}