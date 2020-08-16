package com.wei.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/08/14
 */
public class P76MinimumWindowSubstring {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new P76MinimumWindowSubstring().new Solution().minWindow(s, t));

    }

    class Solution {
        public String minWindow(String s, String t) {
            if (s.isEmpty() || t.isEmpty()) {
                return "";
            }

            int[] cnt = new int[t.length()];
            int[] minCnt = new int[t.length()];
            Map<Character, Integer> chPosMap = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                cnt[i] = 0;
                char ch = t.charAt(i);
                if (!chPosMap.containsKey(ch)) {
                    chPosMap.put(t.charAt(i), i);
                    minCnt[i] = 1;
                } else {
                    minCnt[chPosMap.get(ch)] += 1;
                }
            }

            String r = "";

            int begin = 0;
            int minLength = s.length() + 1;
            int length = 0;
            int totalCh = t.length();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                Integer pos = chPosMap.get(ch);
                if (pos == null) {
                    continue;
                }
                if (cnt[pos] < minCnt[pos]) {
                    length++;
                }
                cnt[pos]++;

                while (totalCh == length) {
                    char beginCh = s.charAt(begin);
                    Integer beginPos = chPosMap.get(beginCh);
                    if (beginPos == null) {
                        begin++;
                        continue;
                    }

                    if (cnt[beginPos] > minCnt[beginPos]) {
                        begin++;
                        cnt[beginPos]--;
                        continue;
                    }
                    break;
                }

                if (totalCh == length) {
                    int currLength = i - begin + 1;
                    if (currLength < minLength) {
                        minLength = currLength;
                        r = s.substring(begin, i + 1);
                    }
                }
            }

            return r;
        }
    }
}
