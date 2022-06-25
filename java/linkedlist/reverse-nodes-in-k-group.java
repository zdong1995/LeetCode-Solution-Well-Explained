class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode nextK = head; // traverse the LinkdeList and find the head of next k-group
        // pick up the k-group
        while (count < k && nextK != null) {
            nextK = nextK.next;
            count++;
        }
        
        if (count == k) {
            // recursion call to reverse the next sub-list in k-group
            ListNode nextHead = reverseKGroup(nextK, k);
            // reverse the current picked k-group
            ListNode newHead = reverseList(head, k);
            // after reverse, head will be the last node of current k-group
            // link last node to the newHead of next sub-list
            head.next = nextHead;
            return newHead;
        }
        // if count < k, remain original order
        return head;
    }
    
    private ListNode reverseList(ListNode head, int k) {
        // base case
        if (k == 1) {
            return head;
        }
        ListNode newHead = reverseList(head.next, k - 1); // recursion call to reverse sublist
        head.next.next = head; // reverse in current level
        head.next = null; // delink
        return newHead;
    }
}
