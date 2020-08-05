package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/03
 */
public class P51NQueens {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> r = new P51NQueens().new Solution().solveNQueens(n);
        System.out.println("[");
        r.forEach(item -> {
            System.out.print("[");
            item.forEach(e -> {
                System.out.println(e + ",");
            });
            System.out.print("],");
            System.out.println();
        });
        System.out.println("]");

    }

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            Q[] nQueens = new Q[n];
            for (int i = 0; i < n; i++) {
                Q q = new Q(i, 0);
                nQueens[i] = q;
            }
            // String[][] matrix = new String[n][n];
            // for (int i = 0; i < matrix.length; i++) {
            // for (int j = 0; j < matrix[i].length; j++) {
            // matrix[i][j] = ".";
            // if (j == 0) {
            // matrix[i][j] = "Q";
            // }
            // }
            // }
            return solveNQueens(nQueens);
        }

        public List<List<String>> solveNQueens(Q[] nQueens) {
            int n = nQueens.length;
            if (checkColumn(nQueens) && checkDiagonal(nQueens)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append('.');
                }
                // String nPoints = sb.toString();

                List<List<String>> result = new LinkedList<>();
                List<String> r = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    // StringBuilder sb = new StringBuilder();
                    // for (int j = 0; j < n; j++) {
                    // sb.sb.append(matrix[i][j]);
                    // }
                    Q q = nQueens[i];
                    sb.replace(q.j - 1, q.j, "Q");
                    r.add(sb.toString());
                    sb.replace(q.j - 1, q.j, ".");
                }
                result.add(r);
                return result;
            }

            int carry = 1;
            for (int i = 0; i < n; i++) {
                if (carry == 0) {
                    break;
                }
                Q q = nQueens[i];
                if (q.j + 1 < n) {
                    carry = 0;
                }
                q.j = (q.j + 1) % n;
                //
                // for (int j = 0; j < n; j++) {
                // if ("Q".equals(matrix[i][j])) {
                // matrix[i][j] = ".";
                // matrix[i][(j + 1) % n] = "Q";
                // if (j + 1 < n) {
                // carry = 0;
                // }
                // break;
                // }
                // }
            }

            return solveNQueens(matrix);
        }

        private boolean checkColumn(String[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if ("Q".equals(matrix[j][i])) {
                        cnt += 1;
                    }
                }
                if (cnt > 1) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkDiagonal(String[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                int j = 0;
                while (".".equals(matrix[i][j])) {
                    j++;
                }
                // /
                // i + j <= 7
                int cnt = 0;
                if (i + j <= 7) {
                    for (int n = i + j; n >= 0; n--) {
                        int m = matrix.length - 1 - n;
                        if ("Q".equals(matrix[m][n])) {
                            cnt += 1;
                        }
                    }
                } else {
                    // i + j > 7
                    for (int n = matrix.length - 1; n >= i + j - matrix.length + 1; n--) {
                        int m = i + j - n;
                        if ("Q".equals(matrix[m][n])) {
                            cnt += 1;
                        }
                    }
                }
                if (cnt > 1) {
                    return false;
                }

                // \
                cnt = 0;
                if (i >= j) {
                    // i >= j
                    for (int n = 0; n < matrix.length - 1 - (i + j); n++) {
                        int m = i - j - n;
                        if ("Q".equals(matrix[m][n])) {
                            cnt += 1;
                        }
                    }
                } else {
                    // i < j
                    for (int n = j - i; n < matrix.length - 1; n++) {
                        int m = n - (j - i);
                        if ("Q".equals(matrix[m][n])) {
                            cnt += 1;
                        }
                    }
                }
                if (cnt > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    class Q {
        int i;
        int j;

        public Q(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
