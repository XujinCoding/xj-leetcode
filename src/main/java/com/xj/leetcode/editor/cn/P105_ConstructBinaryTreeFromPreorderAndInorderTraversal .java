//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2598 👎 0


package com.xj.leetcode.editor.cn;
import com.xj.leetcode.common.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * @author XuJ
 * @date 2025-09-09 14:39:34
 */
class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
		  solution.buildTree(new int[]{3,2,1,4,5},new int[]{1,2,3,4,5});
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	Integer rootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer,Integer> inorderIndex = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndex.put(inorder[i],i);
		}
		return dfs(preorder,inorder,0,inorder.length-1,inorderIndex);

	}
	public TreeNode dfs(int[] preorder, int[] inorder, int left , int right,Map<Integer,Integer> inorderIndex) {
		if (left==right){
			rootIndex++;
			return new TreeNode(inorder[left]);
		}
		if (left>right){
			return null;
		}
		//在列表中选择一个根节点
		int rootVal = preorder[rootIndex];
		rootIndex++;
		TreeNode root = new TreeNode(rootVal);
		TreeNode leftTree = dfs(preorder, inorder, left, inorderIndex.get(rootVal)-1,inorderIndex);
		TreeNode rightTree = dfs(preorder, inorder, inorderIndex.get(rootVal)+1, right,inorderIndex);
		root.left = leftTree;
		root.right = rightTree;
		return root;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
