//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1889 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 *
 * @author XuJ
 * @date 2025-09-09 16:09:47
 */
class P114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P114_FlattenBinaryTreeToLinkedList().new Solution();
        solution.flatten(TreeNode.createRoot(new Integer[]{1, 2, 5, 3, 4, null, 6}));
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
// 左子树最后一个节点的右指针指向右子树的第一个节点
    class Solution {
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            preorderTraversal(root, list);
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }

        public void preorderTraversal(TreeNode root, List<TreeNode> list) {
            if (root != null) {
                list.add(root);
                preorderTraversal(root.left, list);
                preorderTraversal(root.right, list);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class SolutionTest {
        public void flatten(TreeNode root) {
            // 深度优先搜索,遇到新的节点记录下来
            TreeNode head = root;
            List<Integer> linkList = new ArrayList<>();
            dfs(root, linkList);
            for (int i = 1; i < linkList.size(); i++) {
                head.right = new TreeNode(linkList.get(i));
                head.left = null;
                head = head.right;
            }

        }

        public void dfs(TreeNode root, List<Integer> linkList) {
            if (root == null) {
                return;
            }
            linkList.add(root.val);
            dfs(root.left, linkList);
            dfs(root.right, linkList);
        }
    }

}
