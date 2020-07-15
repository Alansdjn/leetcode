package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/07/15
 */
public class P17LetterCombinationsofaPhoneNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String digits = "23";
        List<String> result = new P17LetterCombinationsofaPhoneNumber().new Solution().letterCombinations(digits);
        for (String str : result) {
            System.out.println(str);
        }
    }

    class Solution {
        private List<Character> digit2Letters = new ArrayList<>();
        private List<Character> digit3Letters = new ArrayList<>();
        private List<Character> digit4Letters = new ArrayList<>();
        private List<Character> digit5Letters = new ArrayList<>();
        private List<Character> digit6Letters = new ArrayList<>();
        private List<Character> digit7Letters = new ArrayList<>();
        private List<Character> digit8Letters = new ArrayList<>();
        private List<Character> digit9Letters = new ArrayList<>();
        {
            digit2Letters.add('a');
            digit2Letters.add('b');
            digit2Letters.add('c');
            digit3Letters.add('d');
            digit3Letters.add('e');
            digit3Letters.add('f');
            digit4Letters.add('g');
            digit4Letters.add('h');
            digit4Letters.add('i');
            digit5Letters.add('j');
            digit5Letters.add('k');
            digit5Letters.add('l');
            digit6Letters.add('m');
            digit6Letters.add('n');
            digit6Letters.add('o');
            digit7Letters.add('p');
            digit7Letters.add('q');
            digit7Letters.add('r');
            digit7Letters.add('s');
            digit8Letters.add('t');
            digit8Letters.add('u');
            digit8Letters.add('v');
            digit9Letters.add('w');
            digit9Letters.add('x');
            digit9Letters.add('y');
            digit9Letters.add('z');
        }

        private Map<Character, List<Character>> digitToLetters = new HashMap<>();
        {
            digitToLetters.put('2', digit2Letters);
            digitToLetters.put('3', digit3Letters);
            digitToLetters.put('4', digit4Letters);
            digitToLetters.put('5', digit5Letters);
            digitToLetters.put('6', digit6Letters);
            digitToLetters.put('7', digit7Letters);
            digitToLetters.put('8', digit8Letters);
            digitToLetters.put('9', digit9Letters);
        }

        public List<String> letterCombinations(String digits) {
            return doLetterCombinations(digits);
        }

        private List<String> doLetterCombinations(String digits) {
            if (digits == null || digits.isEmpty()) {
                return Collections.emptyList();
            }

            int[] S = new int[digits.length()];
            int[] L = new int[digits.length()];
            int totalSize = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                S[i] = 0;
                List<Character> digitXLetters = digitToLetters.get(digits.charAt(i));
                L[i] = digitXLetters.size();
                totalSize *= L[i];
                sb.append(digitXLetters.get(0));
            }

            List<String> result = new ArrayList<>();
            result.add(sb.toString());

            for (int i = 1; i < totalSize; i++) {
                int last = digits.length() - 1;
                S[last] += 1;
                sb.setCharAt(last, digitToLetters.get(digits.charAt(last)).get(S[last] % L[last]));
                for (int j = last; j >= 0; j--) {
                    if (S[j] % L[j] != 0) {
                        break;
                    }

                    S[j] = 0;
                    int prev = j - 1;
                    S[prev] += 1;
                    sb.setCharAt(prev, digitToLetters.get(digits.charAt(prev)).get(S[prev] % L[prev]));
                }
                result.add(sb.toString());
            }

            return result;
        }

        private List<String> letterCombinations(String prefix, String digits) {
            if (digits == null || digits.isEmpty()) {
                return Collections.emptyList();
            }
            List<Character> firstDigitLetters = digitToLetters.get(digits.charAt(0));
            if (firstDigitLetters == null) {
                return Collections.emptyList();
            }

            List<String> result = new ArrayList<>();
            if (digits.length() == 1) {
                firstDigitLetters.forEach(letter -> {
                    result.add(prefix + letter);
                });
                return result;
            }

            String newDigits = digits.substring(1);
            for (Character ch : firstDigitLetters) {
                result.addAll(letterCombinations(prefix + ch, newDigits));
            }
            return result;
        }
    }
}
