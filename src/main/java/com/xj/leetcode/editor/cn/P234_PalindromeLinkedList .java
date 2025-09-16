//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 2120 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.Stack;

/**
 * 回文链表
 *
 * @author XuJ
 * @date 2025-09-16 13:16:57
 */
class P234_PalindromeLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P234_PalindromeLinkedList().new Solution();
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
		public boolean isPalindrome(ListNode head) {
			ListNode mid = middleNode(head);
			ListNode head2 = reverseList(mid);
			while (head2 != null) {
				if (head.val != head2.val) { // 不是回文链表
					return false;
				}
				head = head.next;
				head2 = head2.next;
			}
			return true;
		}

		// 876. 链表的中间结点
		private ListNode middleNode(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

		// 206. 反转链表
		private ListNode reverseList(ListNode head) {
			ListNode pre = null;
			ListNode cur = head;
			while (cur != null) {
				ListNode nxt = cur.next;
				cur.next = pre;
				pre = cur;
				cur = nxt;
			}
			return pre;
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

    class SolutionTest {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Stack<Integer> stack = new Stack<>();
            while (head != slow) {
                stack.push(head.val);
                head = head.next;
            }
            if (fast != null) {
                // 节点数量为单数 , 需要跳过slow的节点
                slow = slow.next;
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (pop != slow.val) {
                    return false;
                }
                slow = slow.next;
            }
            return true;

        }
    }
}
