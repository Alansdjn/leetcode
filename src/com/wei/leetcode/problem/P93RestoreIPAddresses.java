package com.wei.leetcode.problem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P93RestoreIPAddresses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] s = {"25525511135", "0000", "1111", "010010", "101023"};

        for (int i = 0; i < s.length; i++) {
            System.out.print("[");
            new P93RestoreIPAddresses().new Solution().restoreIpAddresses(s[i]).forEach(item -> {
                System.out.print("\"" + item + "\", ");
            });;
            System.out.println("]");
        }
    }

    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if (s.length() > 3 * 4) {
                return Collections.emptyList();
            }
            return restoreIpAddresses(s, new LinkedList<>());
        }

        public List<String> restoreIpAddresses(String s, List<String> addresses) {
            List<String> r = new LinkedList<>();
            if (addresses.size() > 0 && s.length() > (4 - addresses.size()) * 3) {
                return r;
            }

            if (addresses.size() == 4) {
                StringBuilder sb = new StringBuilder();
                addresses.forEach(item -> {
                    sb.append(item).append(".");
                });
                r.add(sb.deleteCharAt(sb.length() - 1).toString());
                return r;
            }

            for (int i = 1; i < 4 && i <= s.length(); i++) {
                String val = s.substring(0, i);
                if (isValidInt(val)) {
                    addresses.add(val);
                    r.addAll(restoreIpAddresses(s.substring(i), addresses));
                    addresses.remove(addresses.size() - 1);
                }
            }
            return r;
        }

        private boolean isValidInt(String s) {
            if (s.charAt(0) == '0') {
                return s.length() == 1;
            }

            Integer val = Integer.parseInt(s);
            return (1 <= val && val <= 255);
        }
    }
}
