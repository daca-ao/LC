import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> node = new HashSet<>();
        while (head != null) {
            if (node.contains(head)) {
                return head;
            }
            node.add(head);
            head = head.next;
        }
        return null;
    }
}
// @lc code=end

