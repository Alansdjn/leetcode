package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/10
 */
public class P10RegularExpressionMatching {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println("s = " + s);
        System.out.println("p = " + p);
        System.out.println("Output: " + new P10RegularExpressionMatching().new Solution().isMatch(s, p));

    }

    class Solution {
        public static final char MULTI_SIGN = '*';
        public static final char ANY_SIGN = '.';

        public boolean isMatch(String s, String p) {
            if (s.isEmpty() && p.isEmpty()) {
                return true;
            }
            if (!s.isEmpty() && p.isEmpty()) {
                return false;
            }

            int sLength = s.length();
            int pLength = p.length();
            int i = 0;
            for (int j = 0; j < pLength; j++) {
                char ch = p.charAt(j);
                if ((j + 1 < pLength) && multiSign(p.charAt(j + 1))) {
                    for (int k = i; k <= sLength; k++) {
                        if (anySign(ch) ? matchAny(s.substring(i, k), k - i) : match(s.substring(i, k), ch, k - i)) {
                            if (k == sLength && (j + 2 >= pLength || isMatch("", p.substring(j + 2)))) {
                                return true;
                            }
                            if (k < sLength && j + 2 < pLength && isMatch(s.substring(k), p.substring(j + 2))) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    if (!(anySign(ch) ? matchAny(s.substring(i), 1) : match(s.substring(i), ch, 1))) {
                        return false;
                    }
                    if (i < sLength) {
                        i++;
                    }
                }
            }

            return i == sLength;

        }

        private boolean match(String s, char ch, int num) {
            if (num > s.length()) {
                return false;
            }
            for (int i = 0; i < num; i++) {
                if (s.charAt(i) != ch) {
                    return false;
                }
            }
            return true;
        }

        private boolean matchAny(String s, int num) {
            if (num > s.length()) {
                return false;
            }
            return true;
        }

        private boolean multiSign(char ch) {
            return ch == MULTI_SIGN;
        }

        private boolean anySign(char ch) {
            return ch == ANY_SIGN;
        }
    }

}
