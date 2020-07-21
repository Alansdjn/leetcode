package com.wei.leetcode.problem;

import java.util.Objects;

/**
 * @author wei wang
 * @date 2020/07/18
 */
public class P28ImplementstrStr {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String haystack = "aaabbbbbbbbbbbbbbbbbbbbbbbbbbbbba";
        String needle = "bba";
        System.out.println(new P28ImplementstrStr().new Solution().strStr(haystack, needle));

    }

    class Solution {
        public int strStr(String haystack, String needle) {
            if (Objects.isNull(needle) || needle.isEmpty()) {
                return 0;
            }
            if (Objects.isNull(haystack) || haystack.isEmpty()) {
                return -1;
            }

            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                boolean match = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
            return -1;
        }
    }
}
