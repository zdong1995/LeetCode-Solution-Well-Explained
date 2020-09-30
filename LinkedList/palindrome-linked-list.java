class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // find medium of linkedlist, length of 1st half <= length of 2nd half
        ListNode mid = findMid(head);
        // reverse the 2nd half
        ListNode newHead = reverse(mid.next);
        mid.next = null; // delink
        // determine whether it is palindrome
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        // mid.next = reverse(newHead); -> restore the linkedlist
        return true;
    }
    
    // find the mid node (leftside) of a linkedlist
    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // odd: slow = N+1, fast = 2N+1 = last node
        // even: slow = N, fast = 2N-1 = last two node
        while (fast.next != null && fast.next.next != null) { // odd  OR even number
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}