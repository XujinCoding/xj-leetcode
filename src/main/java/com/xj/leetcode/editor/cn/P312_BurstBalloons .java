//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1464 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.Arrays;

/**
 * 戳气球
 *
 * @author XuJ
 * @date 2025-10-11 13:55:40
 */
class P312_BurstBalloons {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P312_BurstBalloons().new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[][] rec = new int[n + 2][n + 2];
            int[] val = new int[n + 2];
            val[0] = val[n + 1] = 1;
            System.arraycopy(nums, 0, val, 1, n);
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 2; j <= n + 1; j++) {
                    for (int k = i + 1; k < j; k++) {
                        int sum = val[i] * val[k] * val[j];
                        sum += rec[i][k] + rec[k][j];
                        rec[i][j] = Math.max(rec[i][j], sum);
                    }
                }
            }
            return rec[0][n + 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
    class SolutionTest {
        public int[][] rec;
        public int[] val;

        public int maxCoins(int[] nums) {
            int n = nums.length;
            val = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                val[i] = nums[i - 1];
            }
            val[0] = val[n + 1] = 1;
            rec = new int[n + 2][n + 2];
            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(rec[i], -1);
            }
            return solve(0, n + 1);
        }

        public int solve(int left, int right) {
            if (left >= right - 1) {
                return 0;
            }
            if (rec[left][right] != -1) {
                return rec[left][right];
            }
            for (int i = left + 1; i < right; i++) {
                int sum = val[left] * val[i] * val[right];
                sum += solve(left, i) + solve(i, right);
                rec[left][right] = Math.max(rec[left][right], sum);
            }
            return rec[left][right];
        }
    }

}
