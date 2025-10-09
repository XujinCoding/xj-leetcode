//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
//
// Related Topics 数组 哈希表 👍 1381 👎 0


package com.xj.leetcode.editor.cn;
import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 * @author XuJ
 * @date 2025-10-09 13:21:23
 */
class P448_FindAllNumbersDisappearedInAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P448_FindAllNumbersDisappearedInAnArray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		int[] index = new int[nums.length+1];
        for (int num : nums) {
            index[num] = 1;
        }
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < index.length ; i++) {
			if (index[i] == 0){
				res.add(i);
			}
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
