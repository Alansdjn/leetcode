package com.wei.leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wei wang
 * @date 2020/07/24
 */
public class P36ValidSudoku {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new P36ValidSudoku().new Solution().isValidSudoku(board));
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (!isSudokuRowsValid(board)) {
                return false;
            }

            if (!isSudokuColumnsValid(board)) {
                return false;
            }
            if (!isSudokuSubboxesValid(board)) {
                return false;
            }
            return true;
        }

        private boolean isSudokuRowsValid(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                if (!checkRow(board[i])) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkRow(char[] row) {
            Set<Character> chSet = new HashSet<>(row.length);
            for (int i = 0; i < row.length; i++) {
                if ('.' == row[i]) {
                    continue;
                }
                if (chSet.contains(row[i])) {
                    return false;
                }
                chSet.add(row[i]);
            }
            return true;
        }

        private boolean isSudokuColumnsValid(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                if (!checkColumn(board, i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkColumn(char[][] board, int column) {
            Set<Character> chSet = new HashSet<>(board.length);
            for (int i = 0; i < board.length; i++) {
                if ('.' == board[i][column]) {
                    continue;
                }
                if (chSet.contains(board[i][column])) {
                    return false;
                }
                chSet.add(board[i][column]);
            }
            return true;
        }

        private boolean isSudokuSubboxesValid(char[][] board) {
            for (int i = 0; i < board.length; i += 3) {
                for (int j = 0; j < board.length; j += 3) {
                    if (!checkSubbox(board, i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean checkSubbox(char[][] board, int row, int column) {
            int rowEnd = row + 3;
            int columnEnd = column + 3;
            Set<Character> chSet = new HashSet<>(board.length);
            for (int i = row; i < rowEnd; i++) {
                for (int j = column; j < columnEnd; j++) {
                    if ('.' == board[i][j]) {
                        continue;
                    }
                    if (chSet.contains(board[i][j])) {
                        return false;
                    }
                    chSet.add(board[i][j]);
                }
            }
            return true;
        }
    }
}
