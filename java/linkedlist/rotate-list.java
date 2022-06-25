class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // find old tail node and list length
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        if (k == len || k % len == 0) { // no need to rotate
            return head;
        }
        
        ListNode newTail = findLastK(head, k % len + 1);
        ListNode newHead = newTail.next;
        tail.next = head;
        newTail.next = null;
        return newHead;
    }
    
    private ListNode findLastK(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        // we can guarantee fast will not be null
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // fast stop at null, slow stop at last K node
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}