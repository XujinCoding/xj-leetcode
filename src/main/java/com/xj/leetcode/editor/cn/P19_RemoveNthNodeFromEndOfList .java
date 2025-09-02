//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 3172 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author XuJ
 * @date 2025-09-02 11:16:34
 */
class P19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(ListNode.buildLinkedListByArray(new int[]{1, 2}), 2);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            ListNode preHead = new ListNode();
            preHead.next = head;
            ListNode last = preHead;
            ListNode pre = preHead;
            for (int i = 0; i < n; i++) {
                pre = pre.next;
            }
            while (pre != null && pre.next != null) {
                pre = pre.next;
                last = last.next;
            }
            if (last.next != null) {
                ListNode deleteNode = last.next;
                last.next = last.next.next;
                deleteNode.next = null;
            }
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
