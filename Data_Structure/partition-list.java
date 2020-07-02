class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // maintain two dummy head and tails to append new nodes
        ListNode dummySmall = new ListNode(0);
        ListNode dummyLarge = new ListNode(0);
        ListNode tailSmall = dummySmall;
        ListNode tailLarge = dummyLarge;
        
        // iteratively traverse the input list and compare node with target
        // add to small tail and large tail respectively
        while (head != null) {
            if (head.val < x) {
                tailSmall.next = head;
                tailSmall = head; // update tail
            } else {
                tailLarge.next = head;
                tailLarge = head; // update tail
            }
            head = head.next; // move pointer one step forward to continue traverse
        }
        
        // connect small and large linked list
        tailLarge.next = null; // terminate to avoid potential cycle
        tailSmall.next = dummyLarge.next; // dummyLarge.next is the real large head
        return dummySmall.next; // dummySmall.next is the real small head
    }
}