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
    ListNode suc = null; 
    public ListNode helper(ListNode curr, int n) {
        if (n == 1) {
            suc = curr.next;
            return curr;
        }
        ListNode last = helper(curr.next, n - 1);
        curr.next.next = curr;
        curr.next = suc;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return helper(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}