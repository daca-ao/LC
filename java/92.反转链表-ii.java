/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // starter 的好处：
        // head 可能发生变化，避免复杂的分类讨论
        // 多一个引导的 starter 节点，符合从 0 开始的 index
        ListNode starter = new ListNode();
        starter.next = head;

        ListNode pre = starter;
        for (int i = 0; i < left - 1; i++) {
            // 先走 left - 1 步到 left 的前一个节点
            pre = pre.next;
        }
        // 确定需要反转的链表上界
        ListNode leftNode = pre.next;
        pre.next = null;

        // 再从链表上界走 right - left 步到 right 节点
        ListNode rightNode = leftNode;
        for (int i = 0; i < right - left; i++) {
            rightNode = rightNode.next;
        }

        // 确定需要反转的链表下界
        ListNode last = rightNode.next;
        rightNode.next = null;

        // 反转
        reverseList(leftNode);

        // 重新连接
        pre.next = rightNode;
        leftNode.next = last;
        return starter.next;
    }

    private void reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
    }
}
// @lc code=end

