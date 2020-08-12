package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/10
 */
public class P68TextJustification {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        // String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
            "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        new P68TextJustification().new Solution().fullJustify(words, maxWidth).forEach(item -> {
            System.out.println(item);
        });;
    }

    class Solution {
        private static final String SPACE = " ";

        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> r = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                int j = i;
                int length = maxWidth - words[j].length();
                while (j + 1 < words.length && length > words[j + 1].length()) {
                    j++;
                    length -= (1 + words[j].length());
                }

                StringBuilder sb = new StringBuilder();
                if (j + 1 == words.length) {
                    while (i < j) {
                        sb.append(words[i++]).append(SPACE);
                    }
                    sb.append(words[i]);
                } else {
                    int intervalCnt = j - i;
                    int spaceCnt = intervalCnt == 0 ? length : length / intervalCnt;
                    int extraSpace = intervalCnt == 0 ? 0 : length % intervalCnt;
                    while (i < j) {
                        sb.append(words[i++]);
                        for (int k = 0; k <= spaceCnt; k++) {
                            sb.append(SPACE);
                        }
                        if (extraSpace-- > 0) {
                            sb.append(SPACE);
                        }
                        length = 0;
                    }
                    sb.append(words[i]);
                }
                while (length-- > 0) {
                    sb.append(SPACE);
                }

                r.add(sb.toString());
            }
            return r;
        }
    }
}
