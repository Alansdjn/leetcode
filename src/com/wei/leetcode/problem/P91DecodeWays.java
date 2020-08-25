package com.wei.leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wei wang
 * @date 2020/08/22
 */
public class P91DecodeWays {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "10";
        long begin = System.currentTimeMillis();
        // int r = new P91DecodeWays().new Solution().numDecodings_1(s, 0);
        // System.out.println();
        // System.out.println(System.currentTimeMillis() - begin);

        // begin = System.currentTimeMillis();
        System.out.println(new P91DecodeWays().new Solution().numDecodings(s));
        // int r = new P91DecodeWays().new Solution().numDecodings(s);
        System.out.println(System.currentTimeMillis() - begin);
        begin = System.currentTimeMillis();
        System.out.println(new P91DecodeWays().new Solution().numDecodings_1(s, 0));
        System.out.println(System.currentTimeMillis() - begin);
    }

    class Solution {

        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            if (s.length() == 1) {
                return "0".equals(s) ? 0 : 1;
            }

            int[] T = new int[s.length()];
            char ch0 = s.charAt(0);
            T[0] = 0;
            if ('1' <= ch0 && ch0 <= '9') {
                T[0] = 1;
            }

            char ch1 = s.charAt(1);
            T[1] = 0;
            if ('1' <= ch1 && ch1 <= '9') {
                T[1] = T[0];
            }
            if (ch0 == '1' && '0' <= ch1 && ch1 <= '9') {
                T[1] += 1;
            }
            if (ch0 == '2' && '0' <= ch1 && ch1 <= '6') {
                T[1] += 1;
            }

            for (int i = 2; i < s.length(); i++) {
                T[i] = 0;
                ch0 = s.charAt(i - 1);
                ch1 = s.charAt(i);
                if ('1' <= ch1 && ch1 <= '9') {
                    T[i] = T[i - 1];
                }
                if (ch0 == '1' && '0' <= ch1 && ch1 <= '9') {
                    T[i] += T[i - 2];
                }
                if (ch0 == '2' && '0' <= ch1 && ch1 <= '6') {
                    T[i] += T[i - 2];
                }
            }

            return T[s.length() - 1];
        }

        Set<Character> codeChSet = new HashSet<>();
        {
            codeChSet.add('1');
            codeChSet.add('2');
            codeChSet.add('3');
            codeChSet.add('4');
            codeChSet.add('5');
            codeChSet.add('6');
            codeChSet.add('7');
            codeChSet.add('8');
            codeChSet.add('9');
        }
        Set<Character> codeCh09Set = new HashSet<>();
        {
            codeCh09Set.add('0');
            codeCh09Set.add('1');
            codeCh09Set.add('2');
            codeCh09Set.add('3');
            codeCh09Set.add('4');
            codeCh09Set.add('5');
            codeCh09Set.add('6');
            codeCh09Set.add('7');
            codeCh09Set.add('8');
            codeCh09Set.add('9');
        }
        Set<Character> codeCh06Set = new HashSet<>();
        {
            codeCh06Set.add('0');
            codeCh06Set.add('1');
            codeCh06Set.add('2');
            codeCh06Set.add('3');
            codeCh06Set.add('4');
            codeCh06Set.add('5');
            codeCh06Set.add('6');
        }

        public int numDecodings_1(String s, int begin) {
            if (s.length() == begin) {
                return 1;
            }

            char ch0 = s.charAt(begin);
            if (s.length() == begin + 1) {
                return codeChSet.contains(ch0) ? 1 : 0;
            }

            int r = 0;
            if (codeChSet.contains(ch0)) {
                r += numDecodings_1(s, begin + 1);

                char ch1 = s.charAt(begin + 1);
                if (ch0 == '1') {
                    if (codeCh09Set.contains(ch1)) {
                        r += numDecodings_1(s, begin + 2);
                    }
                }
                if (ch0 == '2') {
                    if (codeCh06Set.contains(ch1)) {
                        r += numDecodings_1(s, begin + 2);
                    }
                }
            }

            return r;
        }

        private int numDecodings_2(String s, int begin) {
            if (s.length() == begin) {
                return 1;
            }

            int r = 0;
            char ch0 = s.charAt(begin);
            if (begin + 1 <= s.length() && '1' <= ch0 && ch0 <= '9') {
                r += numDecodings_2(s, begin + 1);
            }
            if (begin + 1 < s.length()) {
                char ch1 = s.charAt(begin + 1);
                if (ch0 == '1' && '0' <= ch1 && ch1 <= '9') {
                    r += numDecodings_2(s, begin + 2);
                }
                if (ch0 == '2' && '0' <= ch1 && ch1 <= '6') {
                    r += numDecodings_2(s, begin + 2);
                }
            }

            return r;
        }

    }
}
