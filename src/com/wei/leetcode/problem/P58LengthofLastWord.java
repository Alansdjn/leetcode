package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/07
 */
public class P58LengthofLastWord {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(new P58LengthofLastWord().new Solution().lengthOfLastWord(s));

    }

    class Solution {
        public int lengthOfLastWord(String s) {

            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int length = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                length++;
                i--;
            }

            return length;
        }
    }
}
