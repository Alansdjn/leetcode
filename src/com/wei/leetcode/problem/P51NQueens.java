package com.wei.leetcode.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author wei wang
 * @date 2020/08/03
 */
public class P51NQueens {
    static int deep = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 9;
        List<List<String>> r = new P51NQueens().new Solution().solveNQueens(n);
        System.out.println(n + " : " + r.size());
        System.out.println("[");
        r.forEach(item -> {
            System.out.println("\t[");
            item.forEach(e -> {
                System.out.println("\t " + e + ",");
            });
            System.out.print("\t],");
            System.out.println();
        });
        System.out.println("]");

    }

    class Solution {

        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> diagonalLeftSet = new HashSet<>();
        Set<Integer> diagonalRightSet = new HashSet<>();

        public List<List<String>> solveNQueens(int n) {
            Q[] nQueens = new Q[n];
            for (int i = 0; i < n; i++) {
                nQueens[i] = new Q(i, 0);
            }

            return solveNQueens(nQueens, 0);
        }

        public List<List<String>> solveNQueens(Q[] nQueens, int row) {

            int n = nQueens.length;
            if (row == n) {
                return createResult(nQueens, n);
            }

            List<List<String>> result = new LinkedList<>();
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
                result.addAll(solveNQueens(nQueens, row + 1));

                columnSet.remove(column);
                diagonalLeftSet.remove(diagonalLeft);
                diagonalRightSet.remove(diagonalRight);
            }

            return result;
        }

        private List<List<String>> createResult(Q[] nQueens, int n) {
            List<List<String>> result = new LinkedList<>();
            List<String> r = new LinkedList<>();
            result.add(r);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append('.');
            }

            for (int i = 0; i < n; i++) {
                Q q = nQueens[i];
                sb.replace(q.column, q.column + 1, "Q");
                r.add(sb.toString());
                sb.replace(q.column, q.column + 1, ".");
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
