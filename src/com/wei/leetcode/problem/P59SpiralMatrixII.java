package com.wei.leetcode.problem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/08
 */
public class P59SpiralMatrixII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            int[][] r = new P59SpiralMatrixII().new Solution().generateMatrix(i);
            System.out.println("[");
            for (int j = 0; j < i; j++) {
                System.out.print("\t[");
                for (int k = 0; k < i; k++) {
                    System.out.print(r[j][k] + ", ");
                }
                System.out.println("\t]");
            }
            System.out.println("]");
        }

    }

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            if (n == 0) {
                return matrix;
            }

            int cnt = 1;
            for (int i = 0; i < (n + 1) / 2; i++) {
                int minRow = i;
                int maxRow = matrix.length - 1 - i;
                int minColumn = i;
                int maxColumn = matrix[i].length - 1 - i;

                int row = i;
                int column = i;
                while (column <= maxColumn) {
                    matrix[row][column] = cnt++;
                    column++;
                }

                column--;
                row++;
                while (row < maxRow) {
                    matrix[row][column] = cnt++;
                    row++;
                }

                while (row == maxRow && row > minRow && column >= minColumn) {
                    matrix[row][column] = cnt++;
                    column--;
                }

                column++;
                row--;
                while (row > minRow && column == minColumn && column < maxColumn) {
                    matrix[row][column] = cnt++;
                    row--;
                }
            }

            return matrix;
        }
    }

}
