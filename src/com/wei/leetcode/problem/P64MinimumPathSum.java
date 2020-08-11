package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/10
 */
public class P64MinimumPathSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new P64MinimumPathSum().new Solution().minPathSum(grid));
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;
            for (int i = 1; i < n; i++) {
                grid[0][i] += grid[0][i - 1];
            }
            for (int i = 1; i < m; i++) {
                grid[i][0] += grid[i - 1][0];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    grid[i][j] += (grid[i - 1][j] < grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1]);
                }
            }

            return grid[m - 1][n - 1];
        }
    }
}
