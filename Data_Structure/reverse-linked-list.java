public class Solution {
    public ListNode reverse(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      //      head -> n2 -> n3 -> ... -> n -> null
      // prev  cur   next
      ListNode cur = head;
      ListNode prev = null;
      ListNode next = null;
      
      // termination condition: prev is new head, is the last one node
      // cur == null
      while (cur != null) {
        next = cur.next; // store next node
        cur.next = prev; // reverse
        prev = cur;
        cur = next;
      }
      return prev;
    }
  }