package com.wei.leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wei wang
 * @date 2020/08/06
 */
public class P52NQueensII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class Solution {

        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> diagonalLeftSet = new HashSet<>();
        Set<Integer> diagonalRightSet = new HashSet<>();

        public int totalNQueens(int n) {
            Q[] nQueens = new Q[n];
            for (int i = 0; i < n; i++) {
                nQueens[i] = new Q(i, 0);
            }

            return solveNQueens(nQueens, 0);
        }

        public int solveNQueens(Q[] nQueens, int row) {

            int n = nQueens.length;
            if (row == n) {
                return 1;
            }

            int result = 0;
            Q q = nQueens[row];
            for (int column = 0; column < n; column++) {
                // |
                if (columnSet.contains(column)) {
                    continue;
                }
                // /
                int diagonalLeft = q.row + column;
                if (diagonalLeftSet.contains(diagonalLeft)) {
                    continue;
                }
                // \
                int diagonalRight = column - q.row;
                if (diagonalRightSet.contains(diagonalRight)) {
                    continue;
                }
                columnSet.add(column);
                diagonalLeftSet.add(diagonalLeft);
                diagonalRightSet.add(diagonalRight);

                q.column = column;
                result += solveNQueens(nQueens, row + 1);

                columnSet.remove(column);
                diagonalLeftSet.remove(diagonalLeft);
                diagonalRightSet.remove(diagonalRight);
            }

            return result;
        }

    }

    class Q {
        int row;
        int column;

        public Q(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
