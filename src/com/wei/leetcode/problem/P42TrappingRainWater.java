package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/07/28
 */
public class P42TrappingRainWater {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new P42TrappingRainWater().new Solution().trap(height));

    }

    class Solution {
        public int trap(int[] height) {
            int i = skipZeros(height, 0);
            int result = 0;
            for (; i < height.length - 2; i++) {
                int j = i + 1;
                int firstMaxPos = j;
                int currHeight = height[j];
                while (j < height.length && height[j] < height[i]) {
                    if (height[j] > height[firstMaxPos]) {
                        firstMaxPos = j;
                        currHeight = height[j];
                    }
                    j++;
                }
                if (j < height.length && height[j] >= height[i]) {
                    firstMaxPos = j;
                    currHeight = height[i];
                }
                if (firstMaxPos == i + 1) {
                    continue;
                }
                int total = (firstMaxPos - i - 1) * currHeight;
                while (i + 1 < firstMaxPos) {
                    i++;
                    total -= height[i];
                }
                result += total;
            }

            return result;
        }

        private int skipZeros(int[] height, int start) {
            int i = start;
            while (i < height.length && height[i] == 0) {
                i++;
            }
            return i;
        }
    }
}
