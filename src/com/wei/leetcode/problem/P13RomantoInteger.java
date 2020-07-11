package com.wei.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/07/11
 */
public class P13RomantoInteger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String num = "MCMXCVIII";
        System.out.println(new P13RomantoInteger().new Solution().romanToInt(num));

    }

    class Solution {
        Map<String, Integer> allBaseInt2Roman = new HashMap<>();
        {
            allBaseInt2Roman.put("I", 1);
            allBaseInt2Roman.put("II", 2);
            allBaseInt2Roman.put("III", 3);
            allBaseInt2Roman.put("IV", 4);
            allBaseInt2Roman.put("V", 5);
            allBaseInt2Roman.put("VI", 6);
            allBaseInt2Roman.put("VII", 7);
            allBaseInt2Roman.put("VIII", 8);
            allBaseInt2Roman.put("IX", 9);

            allBaseInt2Roman.put("X", 10);
            allBaseInt2Roman.put("XX", 20);
            allBaseInt2Roman.put("XXX", 30);
            allBaseInt2Roman.put("XL", 40);
            allBaseInt2Roman.put("L", 50);
            allBaseInt2Roman.put("LX", 60);
            allBaseInt2Roman.put("LXX", 70);
            allBaseInt2Roman.put("LXXX", 80);
            allBaseInt2Roman.put("XC", 90);

            allBaseInt2Roman.put("C", 100);
            allBaseInt2Roman.put("CC", 200);
            allBaseInt2Roman.put("CCC", 300);
            allBaseInt2Roman.put("CD", 400);
            allBaseInt2Roman.put("D", 500);
            allBaseInt2Roman.put("DC", 600);
            allBaseInt2Roman.put("DCC", 700);
            allBaseInt2Roman.put("DCCC", 800);
            allBaseInt2Roman.put("CM", 900);

            allBaseInt2Roman.put("M", 1000);
            allBaseInt2Roman.put("MM", 2000);
            allBaseInt2Roman.put("MMM", 3000);
        }

        public int romanToInt(String s) {

            int result = 0;
            for (int i = 0; i < s.length();) {
                int val = 0;
                for (int j = i + 1; j <= s.length(); ) {
                    Integer tmpVal = allBaseInt2Roman.get(s.substring(i, j));
                    if (tmpVal == null) {
                        i = j - 1;
                        break;
                    }
                    val = tmpVal;
                    j++;
                    if (j > s.length()) {
                        i = s.length();
                    }
                }
                result += val;
            }
            return result;
        }

    }
}
