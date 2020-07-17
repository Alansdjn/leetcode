package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/07/16
 */
public class P22GenerateParentheses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new P22GenerateParentheses().new Solution().generateParenthesis(n);

        result.forEach(str -> {
            System.out.println(str);
        });
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            return generateParenthesis("(", n - 1, n);
        }

        private List<String> generateParenthesis(String prefix, int left, int right) {
            List<String> result = new ArrayList<>();
            if (left == 0 && right == 0) {
                result.add(prefix);
            }

            if (left > 0 && right != 0) {
                result.addAll(generateParenthesis(prefix + "(", left - 1, right));
            }
            if (right > 0 && left < right) {
                result.addAll(generateParenthesis(prefix + ")", left, right - 1));
            }
            return result;
        }

    }
}
