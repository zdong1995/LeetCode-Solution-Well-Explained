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
    // Write your solution here
    if (head == null) {
        return null;
    }
    ListNode fast = head;
    ListNode slow = head;
    
    while (fast != null && fast.next != null) { // 偶数个到头 && 奇数个到头
			  // fast != null 先判断，如果为 false 则不会进行后面的判断，不会触发 NPE
	      fast = fast.next.next;
	      slow = slow.next;
    }
    return slow;
  }
}