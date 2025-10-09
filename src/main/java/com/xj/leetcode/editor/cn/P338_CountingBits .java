//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。 
//
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？ 
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ） 
// 
//
// Related Topics 位运算 动态规划 👍 1403 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.Arrays;

/**
 * 比特位计数
 *
 * @author XuJ
 * @date 2025-10-09 13:44:48
 */
class P338_CountingBits {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P338_CountingBits().new Solution();
        System.out.println(Arrays.toString(solution.countBits(16)));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            res[0] = 0;

            for (int i = 1; i <= n; i++) {
                // 利用位运算特性：i & (i-1) 会去掉i的二进制表示中最右边的1
                res[i] = res[i & (i - 1)] + 1;
            }

            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class SolutionTest {
        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            int index = 1;
            res[0] = 0;
            while (n > 0) {
                res[index] = 1;
                n--;
                int currentIndex = index + 1;
                for (int i = 1; i < index && n > 0; i++) {
                    res[currentIndex] = res[i] + 1;
                    currentIndex++;
                    n--;
                }
                index = currentIndex;
            }
            return res;
        }
    }
}
