//给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1804 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 二叉树的直径
 *
 * @author XuJ
 * @date 2025-09-28 16:49:48
 */
class P543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P543_DiameterOfBinaryTree().new Solution();
        System.out.println(solution.diameterOfBinaryTree(TreeNode.createRoot(new Integer[]{1, 2, 3, 4, 5})));
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int maxVal = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return maxVal-1;

        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftVal = dfs(root.left);
            int rightVal = dfs(root.right);
            int currVal = Math.max(leftVal, rightVal) + 1;
            maxVal = Math.max(leftVal + rightVal + 1, maxVal);
            return currVal;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
