//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 2110 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 旋转图像
 *
 * @author XuJ
 * @date 2025-09-03 14:00:43
 */
class P48_RotateImage {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P48_RotateImage().new Solution();
        solution.rotate(new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix.length == 1) {
                return;
            }
            int n = matrix.length;
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n-2*i-1 ; j++) {
                    int x = i, y = i+j;
                    int preVal=matrix[x][y];
                    do {
                        int lx = y;
                        int ly = n-x-1;
                        int midVal =  matrix[lx][ly];
                        matrix[lx][ly] = preVal;
                        preVal = midVal;
                        x = lx;
                        y = ly;
                    } while (x != i || y != i+j);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
