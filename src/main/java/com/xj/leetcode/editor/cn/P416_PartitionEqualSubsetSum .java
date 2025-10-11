//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2424 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 分割等和子集
 *
 * @author XuJ
 * @date 2025-10-11 09:34:27
 */
class P416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{3, 3, 6, 8, 16, 16, 16, 18, 20}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            int maxVal = 0;
            for (int num : nums) {
                sum += num;
                maxVal = Math.max(maxVal, num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (maxVal > target) {
                return false;
            }
            // 看nums中是否可以有数字相加等于val
            boolean[][] dp = new boolean[n][target + 1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; i++) {
                int num = nums[i];
                for (int j = 1; j <= target; j++) {
                    if (j >= num) {
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
