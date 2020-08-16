package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/12
 */
public class P73SetMatrixZeroes {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        // int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        // int[][] matrix = {{0, 1}};
        new P73SetMatrixZeroes().new Solution().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }

            int rows = matrix.length;
            int columns = matrix[0].length;

            int[] columnSign = new int[columns];
            for (int i = 0; i < columns; i++) {
                columnSign[i] = 0;
            }

            for (int i = 0; i < rows; i++) {
                boolean hasZero = false;
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] == 0) {
                        hasZero = true;
                        columnSign[j] = 1;
                    }
                }

                if (hasZero) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < columns; i++) {
                if (columnSign[i] == 1) {
                    for (int j = 0; j < rows; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
}
