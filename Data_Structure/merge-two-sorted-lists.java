class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy; // maintain as tail
        // iterative until we traverse to the end to one linked list
        while (l1 != null && l2 != null) {
            // compare to select the smalled one node to connect to tail
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next; // update tail
        }
        
        // out of loop condition: l1 == null or l2 == null or both are null
        if (l1 != null) {
            cur.next = l1; // connect the non null one to tail
        } else {
            cur.next = l2; // what ever l2 == null or l2 != null
        }
        return dummy.next; // dummy.next will be the new head
    }
}