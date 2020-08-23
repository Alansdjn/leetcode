package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wei wang
 * @date 2020/08/22
 */
public class P89GrayCode {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int n = 0; n < 10; n++) {
            // int n = 2;
            System.out.println(n + ">> ");
            new P89GrayCode().new Solution().grayCode(n).forEach(item -> {
                System.out.println("\t" + item);
            });
            System.out.println();
        }
    }

    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> r = new LinkedList<>();
            if (n == 0) {
                r.add(0);
                return r;
            }

            List<StringBuilder> from = new LinkedList<>();
            from.add(new StringBuilder("0"));
            from.add(new StringBuilder("1"));
            List<StringBuilder> to = new LinkedList<>();
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < from.size(); j++) {
                    StringBuilder sb = from.get(j);
                    to.add(new StringBuilder(sb).insert(0, '0'));
                }
                for (int j = from.size() - 1; j >= 0; j--) {
                    StringBuilder sb = from.get(j);
                    to.add(new StringBuilder(sb).insert(0, '1'));
                }
                from = to;
                to = new LinkedList<>();
            }

            from.forEach(item -> {
                String binaryStr = item.toString();
                Integer val = Integer.parseInt(binaryStr, 2);
                r.add(val);
            });

            return r;
        }

        public List<String> grayCodeStr(int n) {
            List<String> r = new LinkedList<>();
            if (n == 0) {
                r.add("0");
                return r;
            }

            List<StringBuilder> from = new LinkedList<>();
            from.add(new StringBuilder("0"));
            from.add(new StringBuilder("1"));
            List<StringBuilder> to = new LinkedList<>();
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < from.size(); j++) {
                    StringBuilder sb = from.get(j);
                    to.add(new StringBuilder(sb).insert(0, '0'));
                }
                for (int j = from.size() - 1; j >= 0; j--) {
                    StringBuilder sb = from.get(j);
                    to.add(new StringBuilder(sb).insert(0, '1'));
                }
                from = to;
                to = new LinkedList<>();
            }

            from.forEach(item -> {
                String binaryStr = item.toString();
                r.add(binaryStr);
            });

            return r;
        }
    }
}
