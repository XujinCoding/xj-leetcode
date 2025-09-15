//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2483 👎 0


package com.xj.leetcode.editor.cn;
import com.xj.leetcode.common.*;

/**
 * 乘积最大子数组
 * @author XuJ
 * @date 2025-09-12 16:45:57
 */
class P152_MaximumProductSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P152_MaximumProductSubarray().new Solution();
	 		solution.maxProduct(new int[]{2,-5,-2,-4,3});
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int maxProduct(int[] nums) {
		int length = nums.length;
		long[] maxF = new long[length];
		long[] minF = new long[length];
		for (int i = 0; i < length; i++) {
			maxF[i] = nums[i];
			minF[i] = nums[i];
		}
		for (int i = 1; i < length; ++i) {
			maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
			minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
			if (minF[i] < (-1 << 31)) {
				minF[i] = nums[i];
			}
		}
		int ans = (int) maxF[0];
		for (int i = 1; i < length; ++i) {
			ans = Math.max(ans, (int) maxF[i]);
		}
		return ans;
	}
}

//leetcode submit region end(Prohibit modification and deletion)
class SolutionTest {
	public int maxProduct(int[] nums) {
		if (nums.length ==1){
			return nums[0];
		}
		int[]dpPre = new int[nums.length];
		int[]dpLast = new int[nums.length];
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length ; i++) {
			dpPre[i] = nums[i];
			res = Math.max(res, nums[i]);
		}
		for (int i = 1; i <dpPre.length; i++) {
			for (int j = i; j < dpPre.length; j++) {
				dpLast[j] = dpPre[j-1] * nums[j];
				res = Math.max(res,dpLast[j]);
			}
			dpPre = dpLast;
			dpLast = new int[nums.length];
		}

		return res;
	}
}
}
