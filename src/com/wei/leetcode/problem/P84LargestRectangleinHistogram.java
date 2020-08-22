package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/20
 */
public class P84LargestRectangleinHistogram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new P84LargestRectangleinHistogram().new Solution().largestRectangleArea(heights));

    }

    class Solution {
        public int largestRectangleArea(int[] heights) {
            int largestRectangleArea = 0;
            for (int i = 0; i < heights.length; i++) {
                int height = heights[i];
                int area = height;
                for (int k = i - 1; k >= 0; k--) {
                    if (height > heights[k]) {
                        break;
                    }
                    area += height;
                }
                for (int k = i + 1; k < heights.length; k++) {
                    if (height > heights[k]) {
                        break;
                    }
                    area += height;
                }

                if (largestRectangleArea < area) {
                    largestRectangleArea = area;
                }
            }

            return largestRectangleArea;
        }
    }
}
