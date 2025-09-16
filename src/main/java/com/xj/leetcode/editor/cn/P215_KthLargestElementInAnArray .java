//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2817 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的第K个最大元素
 *
 * @author XuJ
 * @date 2025-09-16 10:16:46
 */
class P215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class SolutionTest {

        public int findKthLargest(int[] nums, int k) {
            /**
             * 未解答
             * 思想:
             * 先将数组分为 k 个段, 在段内球最小值, 段间求最大值
             */

            List<Integer> midList = new ArrayList<>();
            int kthLargest = Integer.MAX_VALUE;
            findMid(0, nums.length - 1, midList, 0, k);
            for (int i = 0; i < midList.size() - 1; i++) {
                int maxVal = Integer.MIN_VALUE;
                for (int j = nums[midList.get(i)]; j < nums[midList.get(i + 1)]; j++) {
                    maxVal = Math.max(maxVal, nums[j]);
                }
                kthLargest = Math.min(kthLargest, maxVal);
            }
            return kthLargest;
        }

        public void findMid(int left, int right, List<Integer> midList, int cur, int k) {
            if (cur >= k - 1) {
                midList.add(left);
                return;
            }
            int mid = (left + right) / 2;
            cur++;
            findMid(left, mid, midList, cur, k);
            cur++;
            findMid(mid + 1, right, midList, cur, k);
        }
    }
}
