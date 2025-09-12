//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2611 👎 0


package com.xj.leetcode.editor.cn;
import com.xj.leetcode.common.*;

/**
 * 排序链表
 * @author XuJ
 * @date 2025-09-11 14:05:58
 */
class P148_SortList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P148_SortList().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode midNode = middleNode(head);
        ListNode leftHead = sortList(head);
        ListNode rightHead =sortList(midNode);
        return merge(leftHead,rightHead);
    }

    // 合并两个升序列表
    public ListNode merge(ListNode leftHead , ListNode rightHead){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(leftHead != null && rightHead!=null){
            if (leftHead.val < rightHead.val){
                cur.next = leftHead;
                leftHead = leftHead.next;
            }else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
        }
        cur.next = leftHead != null ? leftHead : rightHead; // 拼接剩余链表
         return dummy.next;
    }

    //快慢指针找到中间节点
    public ListNode middleNode(ListNode node){
        ListNode pre = node;
        ListNode slow = node;
        ListNode fast = node;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
