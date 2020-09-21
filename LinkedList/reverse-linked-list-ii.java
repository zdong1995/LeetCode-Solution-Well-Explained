class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        // fint the node befor m-th node
        for (int i = 0; i < m - 1; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode tail1 = prev; // the last one node before reversed part
        ListNode tail2 = cur; // the last one node of reversed part
        // reverse
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // prev will stop at n-th node, cur at (n+1)-th node
        if (tail1 != null) {
            // connect tail1 to new head of reversed part, i.e. prev
            tail1.next = prev;
        } else {
            // tail1 is null -> reverse first n elements
            // prev will be the new head of whole list
            head = prev;
        }
        tail2.next = cur;
        return head;
    }
}