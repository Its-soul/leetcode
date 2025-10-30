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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = head.next;
        ListNode odCurr = head;
        ListNode eCurr = even;

        while (odCurr.next != null && eCurr.next != null) {
            odCurr.next = eCurr.next;
            eCurr.next = eCurr.next.next;
            odCurr = odCurr.next;
            eCurr = eCurr.next;
        }

        odCurr.next = even;
        return head;
    }
}
