package com.wei.leetcode.problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wei wang
 * @date 2020/08/02
 */
public class P49GroupAnagrams {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> r = new P49GroupAnagrams().new Solution().groupAnagrams(strs);

        System.out.println("[");
        r.forEach(e -> {
            System.out.print("\t[");
            e.forEach(item -> {
                System.out.print(item + ",\t");
            });
            System.out.println("]");
        });
        System.out.println("]");
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> resultMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String code = createCode(strs[i]);
                List<String> currList = resultMap.getOrDefault(code, new LinkedList<>());
                if (currList.isEmpty()) {
                    resultMap.put(code, currList);
                }
                currList.add(strs[i]);
            }

            List<List<String>> result = new LinkedList<>();
            for (List<String> e : resultMap.values()) {
                result.add(e);
            }

            return result;
        }

        private String createCode(String str) {
            int[] letterCnt = new int[26];
            for (int i = 0; i < 26; i++) {
                letterCnt[i] = 0;
            }
            for (int i = 0; i < str.length(); i++) {
                letterCnt[str.charAt(i) - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(letterCnt[i]);
            }
            return sb.toString();
        }
    }

}
