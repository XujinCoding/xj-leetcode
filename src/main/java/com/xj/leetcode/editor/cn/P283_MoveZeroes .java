//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
// 示例 1:
//
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
//
// 示例 2:
//
//
//输入: nums = [0]
//输出: [0]
//
//
//
// 提示:
//
//
//
// 1 <= nums.length <= 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
//
//
//
//
// 进阶：你能尽量减少完成的操作次数吗？
//
// Related Topics 数组 双指针 👍 2705 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 移动零
 *
 * @author XuJ
 * @date 2025-08-27 15:28:06
 */
class P283_MoveZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P283_MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null) {
                return;
            }
            //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
            int j = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }
            //非0元素统计完了，剩下的都是0了
            //所以第二次遍历把末尾的元素都赋为0即可
            for (int i = j; i < nums.length; ++i) {
                nums[i] = 0;
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

    class SolutionTest {
        public void moveZeroes1(int[] nums) {
            //从左往右第一个0的下标
            int left;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    left = i;
                    for (int j = left; j < nums.length; j++) {
                        if (nums[j] != 0) {
                            int b = nums[left];
                            nums[left] = nums[j];
                            nums[j] = b;
                            break;
                        }
                    }
                }
            }
        }

        public void moveZeroes2(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
        }


    }


}
