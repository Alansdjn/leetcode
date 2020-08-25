package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wei wang
 * @date 2020/07/21
 */
public class P30SubstringwithConcatenationofAllWords {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};

        List<Integer> r = new P30SubstringwithConcatenationofAllWords().new Solution().findSubstring(s, words);
        r.forEach(item -> {
            System.out.print(item + ", ");
        });
    }

    class Solution {

        public List<Integer> findSubstring(String s, String[] words) {
            if (s.isEmpty() || words.length == 0) {
                return Collections.emptyList();
            }

            List<Integer> r = new LinkedList<>();
            Map<String, Integer> wordMap = initWordMap(words);

            int step = words[0].length();
            for (int i = 0; i + step <= s.length(); i++) {
                String key = s.substring(i, i + step);
                Integer val = wordMap.get(key);
                if (val != null) {

                    if (val.intValue() == 1) {
                        wordMap.remove(key);
                    } else {
                        wordMap.put(key, val - 1);
                    }

                    for (int j = i + step; j + step <= s.length(); j += step) {
                        key = s.substring(j, j + step);
                        val = wordMap.get(key);
                        if (val == null) {
                            break;
                        }

                        if (val.intValue() == 1) {
                            wordMap.remove(key);
                        } else {
                            wordMap.put(key, val - 1);
                        }
                    }
                    if (wordMap.isEmpty()) {
                        r.add(i);
                    }
                    wordMap = initWordMap(words);
                }
            }
            return r;
        }

        private Map<String, Integer> initWordMap(String[] words) {
            Map<String, Integer> wordMap = new HashMap<>(words.length);
            for (int i = 0; i < words.length; i++) {
                Integer val = wordMap.get(words[i]);
                if (val == null) {
                    val = 0;
                }
                wordMap.put(words[i], val + 1);
            }
            return wordMap;
        }

        public List<Integer> findSubstring_0(String s, String[] words) {
            if (s.isEmpty() || words.length == 0) {
                return Collections.emptyList();
            }

            Map<String, List<Node>> wordsPos = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                List<Node> currNodes = new ArrayList<>();
                wordsPos.put(words[i], currNodes);
                for (int idx = s.indexOf(words[i]); idx != -1; idx = s.indexOf(words[i], idx + 1)) {
                    currNodes.add(new Node(idx, idx + words[0].length() - 1));
                }
            }

            int[] chooseIdx = new int[words.length];
            return Arrays.asList(findSubstring(words, chooseIdx, wordsPos, 0).toArray(new Integer[0]));
        }

        public Set<Integer> findSubstring(String[] words, int[] chooseIdx, Map<String, List<Node>> pos, int deep) {
            Set<Integer> result = new HashSet<>();

            if (words.length == deep) {
                List<Node> nodes = new ArrayList<>();
                for (int i = 0; i < deep; i++) {
                    nodes.add(pos.get(words[i]).get(chooseIdx[i]));
                }

                Node firstNode = nodes.get(0);
                Node concatenationWords = new Node(firstNode.begin, firstNode.end);
                for (int i = 0; i < deep - 1; i++) {
                    for (Node curr : nodes) {
                        if (concatenationWords.end + 1 == curr.begin) {
                            concatenationWords.end = curr.end;
                            concatenationWords.wordCnt++;
                            break;
                        }
                        if (concatenationWords.begin == curr.end + 1) {
                            concatenationWords.begin = curr.begin;
                            concatenationWords.wordCnt++;
                            break;
                        }
                    }
                    if (i + 2 != concatenationWords.wordCnt) {
                        break;
                    }
                }
                if (concatenationWords.wordCnt == deep) {
                    result.add(concatenationWords.begin);
                }
                return result;
            }

            String key = words[deep];
            for (int i = 0; i < pos.get(key).size(); i++) {
                chooseIdx[deep] = i;
                result.addAll(findSubstring(words, chooseIdx, pos, deep + 1));
            }
            return result;
        }
    }

    class Node {
        int begin;
        int end;
        int wordCnt;

        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
            this.wordCnt = 1;
        }
    }
}
