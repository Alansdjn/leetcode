package com.wei.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3. Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1. Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * 
 * @author wei wang
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s1 = "aab";
		String s2 = "bbbbb";
		String s3 = "pwwkew";

		System.out
				.println(new LongestSubstringWithoutRepeatingCharacters().new Solution().lengthOfLongestSubstring(s1));
		System.out
				.println(new LongestSubstringWithoutRepeatingCharacters().new Solution().lengthOfLongestSubstring(s2));
		System.out
				.println(new LongestSubstringWithoutRepeatingCharacters().new Solution().lengthOfLongestSubstring(s3));

	}

	class Solution {
		public int lengthOfLongestSubstring(String s) {
			int length = 0;
			int begin = 0;
			Map<Character, Integer> prevPositionMap = new HashMap<>();
			for (int currPosition = 0; currPosition < s.length(); currPosition++) {
				Integer prevPosition = prevPositionMap.put(s.charAt(currPosition), currPosition);
				if (prevPosition != null && prevPosition >= begin) {
					length = Math.max(length, currPosition - begin);
					begin = prevPosition + 1;
				}
			}
			length = Math.max(length, s.length() - begin);

			return length;
		}
	}

}
