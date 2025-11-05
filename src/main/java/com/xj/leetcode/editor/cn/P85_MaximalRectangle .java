//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1764 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.Stack;

/**
 * 最大矩形
 *
 * @author XuJ
 * @date 2025-10-17 13:59:52
 */
class P85_MaximalRectangle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P85_MaximalRectangle().new Solution();
        solution.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maximalRectangle(char[][] matrix) {
            int n = matrix[0].length;
            int[] heights = new int[n + 1]; // 末尾多一个 0，理由见我 84 题题解
            int ans = 0;
            for (char[] row : matrix) {
                // 计算底边为 row 的柱子高度
                for (int j = 0; j < n; j++) {
                    if (row[j] == '0') {
                        heights[j] = 0; // 柱子高度为 0
                    } else {
                        heights[j]++; // 柱子高度加一
                    }
                }
                ans = Math.max(ans, largestRectangleArea(heights)); // 调用 84 题代码
            }
            return ans;
        }

        // 84. 柱状图中最大的矩形
        private int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int ans = 0;
            for (int right = 0; right < n; right++) {
                int h = heights[right];
                while (stack.size()>1 && heights[stack.peek()] >= h) {
                    int i = stack.pop();// 矩形的高（的下标）
                    int left = stack.peek(); // 栈顶下面那个数就是 left
                    ans = Math.max(ans, heights[i] * (right - left - 1));
                }
                stack.push(right);
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
