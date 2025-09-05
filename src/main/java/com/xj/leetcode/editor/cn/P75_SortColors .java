//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1980 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 颜色分类
 *
 * @author XuJ
 * @date 2025-09-05 10:56:38
 */
class P75_SortColors {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P75_SortColors().new Solution();
        solution.sortColors(new int[]{2,0,1});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            //思路1 用链表把节点存起来, 用3个指针维护红黄蓝三个区间在链表中的最后一个节点, 顺序输出即可
            //思路2 双指针, 遍历两次 ,第一次把0 都放在最左侧, 第二次把1放在0的后面
            int left = 0;

            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0) {
                    int mid = nums[left];
                    nums[left] = nums[right];
                    nums[right] = mid;
                    left++;
                }
            }
            for (int right = left; right < nums.length; right++) {
                if (nums[right] == 1) {
                    int mid = nums[left];
                    nums[left] = nums[right];
                    nums[right] = mid;
                    left++;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
