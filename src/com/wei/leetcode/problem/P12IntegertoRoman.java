package com.wei.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/07/11
 */
public class P12IntegertoRoman {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int num = 853;
        System.out.println(new P12IntegertoRoman().new Solution().intToRoman(num));

    }

    class Solution {
        final Map<Integer, String> int2Roman = new HashMap<>();
        {
            int2Roman.put(1, "I");
            int2Roman.put(5, "V");
            int2Roman.put(10, "X");
            int2Roman.put(50, "L");
            int2Roman.put(100, "C");
            int2Roman.put(500, "D");
            int2Roman.put(1000, "M");
        }

        public String intToRoman(int num) {
            return method2(num);
        }

        private String method2(int num) {
            Map<Integer, String> allBaseInt2Roman = new HashMap<>();
            allBaseInt2Roman.put(1, "I");
            allBaseInt2Roman.put(2, "II");
            allBaseInt2Roman.put(3, "III");
            allBaseInt2Roman.put(4, "IV");
            allBaseInt2Roman.put(5, "V");
            allBaseInt2Roman.put(6, "VI");
            allBaseInt2Roman.put(7, "VII");
            allBaseInt2Roman.put(8, "VIII");
            allBaseInt2Roman.put(9, "IX");

            allBaseInt2Roman.put(10, "X");
            allBaseInt2Roman.put(20, "XX");
            allBaseInt2Roman.put(30, "XXX");
            allBaseInt2Roman.put(40, "XL");
            allBaseInt2Roman.put(50, "L");
            allBaseInt2Roman.put(60, "LX");
            allBaseInt2Roman.put(70, "LXX");
            allBaseInt2Roman.put(80, "LXXX");
            allBaseInt2Roman.put(90, "XC");

            allBaseInt2Roman.put(100, "C");
            allBaseInt2Roman.put(200, "CC");
            allBaseInt2Roman.put(300, "CCC");
            allBaseInt2Roman.put(400, "CD");
            allBaseInt2Roman.put(500, "D");
            allBaseInt2Roman.put(600, "DC");
            allBaseInt2Roman.put(700, "DCC");
            allBaseInt2Roman.put(800, "DCCC");
            allBaseInt2Roman.put(900, "CM");

            allBaseInt2Roman.put(1000, "M");
            allBaseInt2Roman.put(2000, "MM");
            allBaseInt2Roman.put(3000, "MMM");

            StringBuilder sb = new StringBuilder();
            for (int i = 10; i < 100000; i *= 10) {
                int val = num % i;
                // System.out.println(val);
                String symbol = allBaseInt2Roman.get(val);
                if (symbol != null) {
                    sb.insert(0, allBaseInt2Roman.get(val));
                }
                num -= val;
            }
            return sb.toString();
        }

        private String method1(int num) {

            StringBuilder sb = new StringBuilder();
            for (int i = 10, base = 1; i < 100000; i *= 10, base *= 10) {
                int val = num % i;
                int pos = val / base;
                if (pos < 4) {
                    sb.insert(0, repeatSymbol(getSymbol(base), pos));
                }
                if (pos == 4) {
                    sb.insert(0, getSymbol(5 * base)).insert(0, getSymbol(base));
                }
                if (pos == 5) {
                    sb.insert(0, getSymbol(5 * base));
                }
                if (pos > 5 && pos < 9) {
                    sb.insert(0, repeatSymbol(getSymbol(base), pos - 5)).insert(0, getSymbol(5 * base));
                }
                if (pos == 9) {
                    sb.insert(0, getSymbol(10 * base)).insert(0, getSymbol(base));
                }

                num -= val;
            }

            return sb.toString();

        }

        private String getSymbol(int val) {
            return int2Roman.get(val);
        }

        private String repeatSymbol(String symbol, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(symbol);
            }
            return sb.toString();
        }
    }
}
