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
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // odd (2n + 1): slow -> n + 1 fast -> 2n+1 -> fast.next == null
        // even (2n): slow -> n + 1 fast -> null -> fast == null
        while (fast != null && fast.next != null ) { // even end && odd end
            // check fast != null first to avoid NPE
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}