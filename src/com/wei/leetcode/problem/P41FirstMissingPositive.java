package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/26
 */
public class P41FirstMissingPositive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 2, 2, 1, 1};
        System.out.println(new P41FirstMissingPositive().new Solution().firstMissingPositive(nums));

    }

    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums.length == 0) {
                return 1;
            }

            int i = 0;
            while (i < nums.length && nums[i] <= 0) {
                i++;
            }
            if (i == nums.length) {
                return 1;
            }

            RangeNode head = new RangeNode(nums[i], nums[i]);
            for (i += 1; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    continue;
                }
                RangeNode curr = head;
                while (curr.end < nums[i]) {
                    if (curr.next != null) {
                        curr = curr.next;
                    } else {
                        break;
                    }
                }
                if (curr.begin <= nums[i] && nums[i] <= curr.end) {
                    continue;
                }

                // curr is the last node
                if (curr.end < nums[i]) {
                    if (curr.end + 1 == nums[i]) {
                        curr.end = nums[i];
                    } else {
                        RangeNode node = new RangeNode(nums[i], nums[i]);
                        curr.next = node;
                        node.prev = curr;
                    }
                } else {
                    // prev ->(<- node ->)<- curr -><- curr.next
                    if (curr.prev != null) {
                        RangeNode prev = curr.prev;
                        if (prev.end + 1 == nums[i] && curr.begin - 1 == nums[i]) {
                            prev.end = curr.end;
                            prev.next = curr.next;
                            if (curr.next != null) {
                                curr.next.prev = prev;
                            }
                        } else if (prev.end + 1 == nums[i]) {
                            prev.end = nums[i];
                        } else if (curr.begin - 1 == nums[i]) {
                            curr.begin = nums[i];
                        } else {
                            RangeNode node = new RangeNode(nums[i], nums[i]);
                            prev.next = node;
                            node.next = curr;
                            curr.prev = node;
                            node.prev = prev;
                        }
                    } else {
                        // (<- node ->)<- curr -><- curr.next
                        if (curr.begin - 1 == nums[i]) {
                            curr.begin = nums[i];
                        } else {
                            RangeNode node = new RangeNode(nums[i], nums[i]);
                            node.next = curr;
                            curr.prev = node;
                            head = node;
                        }
                    }
                }
            }

            if (head.begin <= 1) {
                return head.end + 1;
            }
            return 1;
        }
    }

    class RangeNode {
        int begin;
        int end;
        RangeNode next;
        RangeNode prev;

        public RangeNode(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
