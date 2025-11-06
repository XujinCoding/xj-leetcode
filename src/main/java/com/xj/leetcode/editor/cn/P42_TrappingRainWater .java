//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5955 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 接雨水
 *
 * @author XuJ
 * @date 2025-11-05 16:07:14
 */
class P42_TrappingRainWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P42_TrappingRainWater().new Solution();
        solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int preMax = 0; // 前缀最大值，随着左指针 left 的移动而更新
            int sufMax = 0; // 后缀最大值，随着右指针 right 的移动而更新
            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                preMax = Math.max(preMax, height[left]);
                sufMax = Math.max(sufMax, height[right]);
                //接住的雨水量 = min(左边最大高度, 右边最大高度) - 当前高度
                if (preMax < sufMax) {
                    ans += preMax - height[left];
                    left++;
                } else {
                    ans += sufMax - height[right];
                    right--;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
