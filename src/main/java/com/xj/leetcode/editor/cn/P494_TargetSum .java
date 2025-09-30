//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 2218 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 目标和
 *
 * @author XuJ
 * @date 2025-09-29 09:10:49
 */
class P494_TargetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P494_TargetSum().new Solution();
        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int s = 0;
            for (int x : nums) {
                s += x;
            }

            s -= Math.abs(target);
            if (s < 0 || s % 2 == 1) {
                return 0;
            }

            int m = s / 2; // 背包容量
            int n = nums.length;
            int[][] memo = new int[n][m + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1); // -1 表示没有计算过
            }

            return dfs(n - 1, m, nums, memo);
        }

        private int dfs(int i, int c, int[] nums, int[][] memo) {
            if (i < 0) {
                return c == 0 ? 1 : 0;
            }
            if (memo[i][c] != -1) { // 之前计算过
                return memo[i][c];
            }
            int res = dfs(i - 1, c, nums, memo); // 不选
            if (c >= nums[i]) {
                res += dfs(i - 1, c - nums[i], nums, memo); // 不选
            }
            return memo[i][c] = res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
