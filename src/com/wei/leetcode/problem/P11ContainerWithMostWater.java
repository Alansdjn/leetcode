package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/07/11
 */
public class P11ContainerWithMostWater {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new P11ContainerWithMostWater().new Solution().maxArea(height));
    }

    class Solution {
        public int maxArea(int[] height) {
            List<Pair> pairs = new ArrayList<>(height.length);
            for (int i = 0; i < height.length; i++) {
                pairs.add(new Pair(height[i], i));
            }

            Collections.sort(pairs, new Comparator<Pair>() {

                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.val - o2.val;
                }

            });

            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                Pair curr = pairs.get(i);
                int maxLength = 0;
                for (int j = i + 1; j < height.length; j++) {
                    Pair tmp = pairs.get(j);
                    int length = Math.abs(curr.position - tmp.position);
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }

                int area = curr.val * maxLength;
                maxArea = (maxArea < area) ? area : maxArea;
            }

            return maxArea;
        }
    }

    class Pair {
        int val;
        int position;

        public Pair(int val, int pos) {
            this.val = val;
            this.position = pos;
        }
    }

}
