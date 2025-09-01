//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3171 👎 0


package com.xj.leetcode.editor.cn;
import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @author XuJ
 * @date 2025-09-01 15:03:29
 */
class P46_Permutations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P46_Permutations().new Solution();
		  solution.permute(new int[]{1,2,3});
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(res,path,nums);
		return res;
    }
	public void dfs(List<List<Integer>> result, List<Integer> path,int[] nums){
		if (path.size() == nums.length){
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=100) {
				int check = nums[i];
				path.add(check);
				nums[i]=100;
				dfs(result, path, nums);
				nums[i] = check;
				path.remove(path.size()-1);
			}
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
