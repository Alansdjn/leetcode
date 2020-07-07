package com.wei.leetcode.problem;

public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String result = new ZigZagConversion().new Solution().convert(s, 4);
        if (result == null) {
            System.out.println("result: null");
        } else {
            System.out.println("result: [" + s + "]");
            System.out.println("result: [" + result + "]");
            System.out.println("result: [PINALSIGYAHRPI]");
            System.out
                .println("result: [ \"PINALSIGYAHRPI\".equals(result) == " + "PINALSIGYAHRPI".equals(result) + "]");
        }

    }

    class Solution {
        public String convert(String s, int numRows) {
            StringBuilder[] T = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                T[i] = new StringBuilder();
            }

            if (numRows == 1) {
                return s;
            }
            // int N = s.length();
            int steps = (s.length() + numRows - 2) / (numRows - 1);
            for (int i = 0; i < steps; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j <= numRows - 2; j++) {
                        int pos = (numRows - 1) * i + j;
                        if (pos >= s.length()) {
                            break;
                        }
                        T[j].append(s.charAt(pos));
                    }
                }

                if (i % 2 == 1) {
                    for (int j = numRows - 1; j > 0; j--) {
                        int pos = (numRows - 1) * i + numRows - j - 1;
                        if (pos >= s.length()) {
                            break;
                        }
                        T[j].append(s.charAt(pos));
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                // System.out.println(T[i].toString());
                sb.append(T[i]);
            }
            return sb.toString();
        }
    }
}
