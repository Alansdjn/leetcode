package com.wei.leetcode.problem;

import java.util.LinkedList;
import java.util.List;

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
        int n = 7;
        List<List<String>> r = new P51NQueens().new Solution().solveNQueens(n);
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

        public List<List<String>> solveNQueens(int n) {
            Q[] nQueens = new Q[n];
            for (int i = 0; i < n; i++) {
                Q q = new Q(i, 0);
                nQueens[i] = q;
            }

            return solveNQueens(nQueens);
        }

        public List<List<String>> solveNQueens(Q[] nQueens) {
            int n = nQueens.length;

            System.out.print(deep++);
            System.out.print(": [ ");
            for (int i = 0; i < n; i++) {
                System.out.print("(" + nQueens[i].i + ", " + nQueens[i].j + "), ");
            }
            System.out.println("]");

            List<List<String>> result = new LinkedList<>();
            if (checkColumn(nQueens) && checkDiagonal(nQueens)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append('.');
                }

                List<String> r = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    Q q = nQueens[i];
                    sb.replace(q.j, q.j + 1, "Q");
                    r.add(sb.toString());
                    sb.replace(q.j, q.j + 1, ".");
                }
                result.add(r);
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
            }
            if (carry == 1) {
                return result;
            }

            List<List<String>> r = solveNQueens(nQueens);
            result.addAll(r);
            return result;
        }

        private boolean checkColumn(Q[] nQueens) {
            int n = nQueens.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nQueens[i].j == nQueens[j].j) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean checkDiagonal(Q[] nQueens) {
            int n = nQueens.length;
            for (int i = 0; i < n - 1; i++) {
                // /
                int diagonalLeft = nQueens[i].i + nQueens[i].j;
                // \
                int diagonalRight = nQueens[i].j - nQueens[i].i;
                for (int j = i + 1; j < n; j++) {
                    if (diagonalLeft == (nQueens[j].i + nQueens[j].j) || diagonalRight == nQueens[j].j - nQueens[j].i) {
                        return false;
                    }
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
