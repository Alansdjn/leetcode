package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/02
 */
public class P48RotateImage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // int[][] matrix =
        // {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        System.out.println("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ",\t");
            }
            System.out.println("],");
        }
        System.out.println("]");

        new P48RotateImage().new Solution().rotate(matrix);

        System.out.println("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ",\t");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    class Solution {
        public void rotate(int[][] matrix) {
            for (int loop = 0; loop < matrix.length / 2; loop++) {
                int begin = loop;
                int end = matrix.length - 1 - loop;
                for (int i = 0; i < end - begin; i++) {
                    int tmp = matrix[begin][begin + i];
                    matrix[begin][begin + i] = matrix[end - i][begin];
                    matrix[end - i][begin] = matrix[end][end - i];
                    matrix[end][end - i] = matrix[begin + i][end];
                    matrix[begin + i][end] = tmp;
                }
            }
        }
    }
}
