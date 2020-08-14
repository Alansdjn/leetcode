package com.wei.leetcode.problem;

import java.util.Stack;

/**
 * @author wei wang
 * @date 2020/08/12
 */
public class P71SimplifyPath {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] path = {"/abc/...", "/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/a/../../b/../c//.//",
            "/a//b////c/d//././/.."};
        String[] expected = {"/abc/...", "/home", "/", "/home/foo", "/c", "/c", "/a/b/c"};
        for (int i = 0; i < path.length; i++) {
            System.out.println("Input: " + path[i]);
            System.out.println("Expected: " + expected[i]);
            System.out.println("Output: " + new P71SimplifyPath().new Solution().simplifyPath(path[i]));
            System.out.println("============");
        }

    }

    class Solution {

        private static final String SLASH_STR = "/";
        private static final String PERIOD_STR = ".";
        private static final String D_PERIOD_STR = "..";
        private static final char SLASH_C = '/';

        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            stack.push(SLASH_STR);
            for (int i = 1; i < path.length(); i++) {
                // /
                if (path.charAt(i) == SLASH_C) {
                    if (!SLASH_STR.equals(stack.peek())) {
                        stack.push(SLASH_STR);
                    }
                    continue;
                }

                // xxxx or . or ..
                int j = i;
                while (j < path.length() && path.charAt(j) != SLASH_C) {
                    j++;
                }
                String tmp = path.substring(i, j);
                if (tmp.length() == 1 && PERIOD_STR.equals(tmp)) {
                    // nothing to do
                } else if (tmp.length() == 2 && D_PERIOD_STR.equals(tmp)) {
                    int k = 2;
                    while (stack.size() > 1 && k-- > 0) {
                        stack.pop();
                    }
                } else {
                    stack.push(path.substring(i, j));
                }
                i = j - 1;
            }

            StringBuilder sb = new StringBuilder();
            if (SLASH_STR.equals(stack.peek()) && stack.size() > 1) {
                stack.pop();
            }
            while (!stack.empty()) {
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }
    }
}
