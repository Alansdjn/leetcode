package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/26
 */
public class P43MultiplyStrings {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String num1 = "9133";
        String num2 = "0";

        System.out.println(new P43MultiplyStrings().new Solution().multiply(num1, num2));
    }

    class Solution {
        public String multiply(String num1, String num2) {
            String result = "0";
            if (result.equals(num1) || result.equals(num2)) {
                return result;
            }
            String prefix = "";
            for (int i = num2.length() - 1; i >= 0; i--) {
                result = sum(result, multiply1(num1, num2.charAt(i) - '0', prefix));
                prefix += "0";
            }
            return result;
        }

        public String multiply1(String num1, int num2, String prefix) {
            StringBuilder sb = new StringBuilder(prefix);
            int carry = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int multiply = (num1.charAt(i) - '0') * num2 + carry;
                if (multiply >= 10) {
                    carry = multiply / 10;
                    multiply = multiply % 10;
                } else {
                    carry = 0;
                }
                sb.append(multiply);
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }

        public String sum(String num1, String num2) {
            int length = Math.max(num1.length(), num2.length());

            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int i = 0; i < length; i++) {
                int sum = carry;
                if (i >= num1.length()) {
                    sum += num2.charAt(num2.length() - 1 - i) - '0';
                } else if (i >= num2.length()) {
                    sum += num1.charAt(num1.length() - 1 - i) - '0';
                } else {
                    sum += (num1.charAt(num1.length() - 1 - i) - '0') + (num2.charAt(num2.length() - 1 - i) - '0');
                }
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                sb.append(sum);
            }
            if (carry == 1) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }

}
