package com.wei.leetcode.problem;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author wei wang
 * @date 2020/08/17
 */
public class P79WordSearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {//
            {'A', 'B', 'C', 'E'}, //
            {'S', 'F', 'C', 'S'}, //
            {'A', 'D', 'E', 'E'}, //
        };
        // String word = "ABCCED";
        // String word = "SEE";
        // String word = "ABCB";
//        String word = "ABCESEECFDAS";
        String word = "g";
        System.out.println(new P79WordSearch().new Solution().exist(board, word));

    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            if (board.length == 0 || board.length * board[0].length < word.length()) {
                return false;
            }

            Set<Node> nodeSet = new HashSet<>();
            Stack<Node> nodeStack = new Stack<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    // System.out.println("(" + i + "," + j + ")");
                    if (board[i][j] != word.charAt(0)) {
                        continue;
                    }

                    nodeStack.push(new Node(i, j, 0));
                    nodeSet.add(nodeStack.peek());
                    while (!nodeStack.empty() && nodeStack.size() < word.length()) {
                        Node currNode = nodeStack.peek();
                        int row = currNode.row;
                        int column = currNode.column;
                        currNode.step++;

                        int k = nodeStack.size();
                        // row - 1 >= 0 && board[row - 1][column]
                        if (currNode.step == 1) {
                            if (row - 1 >= 0 && board[row - 1][column] == word.charAt(k)) {
                                Node node = new Node(row - 1, column, 0);
                                if (!nodeSet.contains(node)) {
                                    nodeStack.push(node);
                                    nodeSet.add(node);
                                    continue;
                                }
                            }
                            currNode.step++;
                        }
                        // row + 1 < board.length && board[row + 1][column]
                        if (currNode.step == 2) {
                            if (row + 1 < board.length && board[row + 1][column] == word.charAt(k)) {
                                Node node = new Node(row + 1, column, 0);
                                if (!nodeSet.contains(node)) {
                                    nodeStack.push(node);
                                    nodeSet.add(node);
                                    continue;
                                }
                            }
                            currNode.step++;
                        }
                        // column - 1 >= 0 && board[row][column - 1]
                        if (currNode.step == 3) {
                            if (column - 1 >= 0 && board[row][column - 1] == word.charAt(k)) {
                                Node node = new Node(row, column - 1, 0);
                                if (!nodeSet.contains(node)) {
                                    nodeStack.push(node);
                                    nodeSet.add(node);
                                    continue;
                                }
                            }
                            currNode.step++;
                        }
                        // column + 1 < board[row].length && board[row][column + 1]
                        if (currNode.step == 4) {
                            if (column + 1 < board[row].length && board[row][column + 1] == word.charAt(k)) {
                                Node node = new Node(row, column + 1, 0);
                                if (!nodeSet.contains(node)) {
                                    nodeStack.push(node);
                                    nodeSet.add(node);
                                    continue;
                                }
                            }
                            currNode.step++;
                        }

                        if (currNode.step == 5) {
                            nodeSet.remove(nodeStack.pop());
                        }
                    }

                    if (nodeSet.size() == word.length()) {
                        return true;
                    }
                    nodeStack.clear();
                    nodeSet.clear();
                }
            }
            return false;
        }
    }

    class Node {
        int row;
        int column;

        /**
         * 1: row - 1; 2: row + 1; 3: column - 1; 4: column + 1
         */
        int step;

        public Node(int row, int column, int step) {
            this.row = row;
            this.column = column;
            this.step = step;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = row * 1000;
            result = result + column;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node)obj;
            if (column != other.column)
                return false;
            if (row != other.row)
                return false;
            return true;
        }
    }
}
