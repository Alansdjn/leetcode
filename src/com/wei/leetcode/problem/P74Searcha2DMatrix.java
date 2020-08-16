package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/13
 */
public class P74Searcha2DMatrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        // int[][] matrix = {{1, 3, 5, 7}};
        int target = 15;
        System.out.println(new P74Searcha2DMatrix().new Solution().searchMatrix(matrix, target));

    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int begin = 0;
            int end = matrix.length;
            int columns = matrix[0].length - 1;
            if (target < matrix[0][0] || matrix[end - 1][columns] < target) {
                return false;
            }

            while (begin < end) {
                if (matrix[begin][0] == target || matrix[begin][columns] == target) {
                    return true;
                }
                if (matrix[begin][0] < target && target < matrix[begin][columns]) {
                    break;
                }
                begin++;
            }

            return begin == end ? false : bSearch(matrix[begin], target) ;
        }

        private boolean bSearch(int[] arr, int target) {
            int begin = 0;
            int end = arr.length - 1;
            while (begin < end) {
                int mid = (begin + end) / 2;
                if (arr[mid] == target) {
                    return true;
                }

                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            if (begin == end) {
                return arr[begin] == target;
            }
            return false;
        }
    }
}
