//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2607 👎 0


package com.xj.leetcode.editor.cn;
import com.xj.leetcode.common.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * @author XuJ
 * @date 2025-08-28 13:58:44
 */
class P128_LongestConsecutiveSequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P128_LongestConsecutiveSequence().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		int max = 0;
		for (int num : nums) {
			numSet.add(num);
		}
		for (int pre : numSet){
			// 如果pre-1 在集合中, 那以pre为开头的序列一定不是最长序列
			if (numSet.contains(pre-1)){
				continue;
			}
			int last = pre+1;
			while (numSet.contains(last)){
				last++;
			}
			max = Math.max(max, last-pre);
		}
		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
