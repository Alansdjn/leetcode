package com.wei.leetcode.problem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/06
 */
public class P54SpiralMatrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // int[][] matrix = {{7}, {9}, {6}};
        int[][] matrix = {{2, 5, 8}, {4, 0, 1}};
        new P54SpiralMatrix().new Solution().spiralOrder(matrix).forEach(item -> {
            System.out.print(item + ", ");
        });;

    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return Collections.emptyList();
            }

            List<Integer> r = new LinkedList<>();
            int min = (matrix.length < matrix[0].length ? matrix.length + 1 : matrix[0].length + 1) / 2;
            for (int i = 0; i < min; i++) {
                int minRow = i;
                int maxRow = matrix.length - 1 - i;
                int minColumn = i;
                int maxColumn = matrix[i].length - 1 - i;

                int row = i;
                int column = i;
                while (column <= maxColumn) {
                    r.add(matrix[row][column]);
                    column++;
                }

                column--;
                row++;
                while (row < maxRow) {
                    r.add(matrix[row][column]);
                    row++;
                }

                while (row == maxRow && row > minRow && column >= minColumn) {
                    r.add(matrix[row][column]);
                    column--;
                }

                column++;
                row--;
                while (row > minRow && column == minColumn && column < maxColumn) {
                    r.add(matrix[row][column]);
                    row--;
                }
            }
            return r;
        }
    }
}
