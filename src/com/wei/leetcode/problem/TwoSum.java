/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author wei wang
 *
 */
package com.wei.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 7, 11, 15 };
		int target = 6;
		int[] result =  new TwoSum(). new Solution().twoSum(nums, target);
		if (result == null) {
			System.out.println("result: null");
		} else {
			System.out.println("result: [" + result[0] + ", " + result[1] + "]");
		}

	}

	class Solution {
		public int[] twoSum(int[] nums, int target) {
			if (nums == null || nums.length < 2) {
				return null;
			}

			Map<Integer, Integer> numsMap = new HashMap<>(nums.length / 2);
			for (int idx = 0; idx < nums.length; idx++) {
				int diff = target - nums[idx];
				if (numsMap.get(diff) == null) {
					numsMap.put(nums[idx], idx);
				} else {
					return new int[] { numsMap.get(diff), idx };
				}
			}
			return null;
		}
	}

}
