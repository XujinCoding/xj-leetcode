//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2681 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 不同的二叉搜索树
 *
 * @author XuJ
 * @date 2025-09-08 14:42:18
 */
class P96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
		System.out.println(solution.numTrees(4));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * 	动态规划 , dp[i] += dp[j - 1] * dp[i - j];
	 * 	i = 表示正在计算的节点数
	 * 	j = 选中的根节点
 	 */
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
			dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
					// j - 1 以j为根节点左测剩余节点数量
					// n - j 以j为根节点右测剩余节点数量
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
