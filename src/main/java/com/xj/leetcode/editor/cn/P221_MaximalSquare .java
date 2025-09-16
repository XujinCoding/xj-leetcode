//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1831 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 最大正方形
 *
 * @author XuJ
 * @date 2025-09-16 11:01:26
 */
class P221_MaximalSquare {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P221_MaximalSquare().new Solution();
        char[][] testCase = {
                {'1', '0', '1', '0', '0', '1', '1', '1', '0'},
                {'1', '1', '1', '0', '0', '0', '0', '0', '1'},
                {'0', '0', '1', '1', '0', '0', '0', '1', '1'},
                {'0', '1', '1', '0', '0', '1', '0', '0', '1'},
                {'1', '1', '0', '1', '1', '0', '0', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '0'},
                {'1', '1', '1', '0', '1', '0', '0', '0', '1'},
                {'0', '1', '1', '1', '1', '0', '0', '1', '0'},
                {'1', '0', '0', '1', '1', '1', '0', '0', '0'}
        };
        solution.maximalSquare(testCase);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            int max = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (matrix[i - 1][j - 1] == '0') {
                        dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }
            return max * max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class SolutionTest {
        public int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            int max = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (matrix[i - 1][j - 1] == '0') {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (dp[i - 1][j - 1] == 0) {
                        dp[i][j] = 1;
                    } else if (dp[i - 1][j] == dp[i - 1][j - 1] && dp[i][j - 1] == dp[i - 1][j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else if (dp[i - 1][j] != 0 && dp[i][j - 1] != 0) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }

            }
            return max * max;
        }
    }

}
