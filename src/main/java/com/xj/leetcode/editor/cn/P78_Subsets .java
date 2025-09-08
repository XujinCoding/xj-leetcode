//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2538 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author XuJ
 * @date 2025-09-05 11:12:18
 */
class P78_Subsets {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P78_Subsets().new Solution();
        solution.subsets(new int[]{1, 2, 3, 4});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int num : nums) {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> currentIndex = new ArrayList<>(res.get(j));
                    currentIndex.add(num);
                    res.add(currentIndex);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
