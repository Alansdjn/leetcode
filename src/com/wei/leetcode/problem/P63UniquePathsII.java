package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/10
 */
public class P63UniquePathsII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // int[][] obstacleGrid = {{0, 1}, {0, 0}};
        // int[][] obstacleGrid = {{0, 1}};
        int[][] obstacleGrid = {{1}};
        System.out.println(new P63UniquePathsII().new Solution().uniquePathsWithObstacles(obstacleGrid));

    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid.length == 0) {
                return 0;
            }

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            if (obstacleGrid[0][0] == 1) {
                obstacleGrid[0][0] = 0;
            } else {
                obstacleGrid[0][0] = 1;
            }
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[0][i] == 1) {
                    obstacleGrid[0][i] = 0;
                } else {
                    obstacleGrid[0][i] = obstacleGrid[0][i - 1];
                }
            }
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    obstacleGrid[i][0] = 0;
                } else {
                    obstacleGrid[i][0] = obstacleGrid[i - 1][0];
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }

            return obstacleGrid[m - 1][n - 1];
        }
    }
}
