// iterative
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = head;
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

// recursion
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        // connect the next node after deleteing duplicate to head
        if (head.val == head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }
}