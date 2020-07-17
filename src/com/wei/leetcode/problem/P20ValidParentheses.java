package com.wei.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/07/16
 */
public class P20ValidParentheses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "";
        System.out.println(new P20ValidParentheses().new Solution().isValid(s));

    }

    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> brackets = new HashMap<>();
            brackets.put('(', ')');
            brackets.put(')', '(');
            brackets.put('[', ']');
            brackets.put(']', '[');
            brackets.put('{', '}');
            brackets.put('}', '{');

            if (s.length() == 0) {
                return true;
            }
            if (s.length() % 2 == 1) {
                return false;
            }

            StringBuilder sb = new StringBuilder("" + s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == brackets.get(s.charAt(i))) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(s.charAt(i));
                }
            }

            return sb.length() == 0;
        }
    }
}
