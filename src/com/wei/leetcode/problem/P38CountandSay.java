package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/24
 */
public class P38CountandSay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i < 30; i++) {
            System.out.println(i + ": " + new P38CountandSay().new Solution().countAndSay(i));
        }

    }

    class Solution {
        public String countAndSay(int n) {
            return countAndSay(2, "1", n);
        }

        public String countAndSay(int curr, String prevSay, int target) {
            if (curr > target) {
                return prevSay;
            }

            StringBuilder result = new StringBuilder();
            char currCh = prevSay.charAt(0);
            int cnt = 1;
            for (int i = 1; i < prevSay.length(); i++) {
                if (currCh == prevSay.charAt(i)) {
                    cnt++;
                } else {
                    result.append(cnt).append(currCh);
                    cnt = 1;
                    currCh = prevSay.charAt(i);
                }
            }
            result.append(cnt).append(currCh);
            return countAndSay(curr + 1, result.toString(), target);
        }
    }
}
