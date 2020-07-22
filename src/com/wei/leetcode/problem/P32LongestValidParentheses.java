package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/07/22
 */
public class P32LongestValidParentheses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = ")(((((((((())))))))))";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));

    }

    class Solution {

        private static final char LEFT_PARENTHESIS = '(';
        private static final char RIGHT_PARENTHESIS = ')';

        public int longestValidParentheses(String s) {
            int result = 0;
            Map<Integer, Integer> posMatchCnt = new HashMap<>();
            List<Node> stack = new ArrayList<>(s.length());

            for (int pos = 0; pos < s.length(); pos++) {
                char currCh = s.charAt(pos);
                if (currCh == LEFT_PARENTHESIS || stack.isEmpty()) {
                    stack.add(new Node(currCh, pos));
                    continue;
                }

                Node prevNode = stack.get(stack.size() - 1);
                if (prevNode.val == RIGHT_PARENTHESIS) {
                    stack.add(new Node(currCh, pos));
                    continue;
                }

                int length = 2 + posMatchCnt.getOrDefault(pos - 1, 0) + posMatchCnt.getOrDefault(prevNode.pos - 1, 0);
                posMatchCnt.put(pos, length);
                result = (result < length ? length : result);
                stack.remove(stack.size() - 1);
            }

            return result;
        }
    }

    class Node {
        char val;
        int pos;

        public Node(char val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}
