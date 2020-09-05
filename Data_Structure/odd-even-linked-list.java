class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode tailOdd = dummyOdd;
        ListNode tailEven = dummyEven;
        int i = 1;
        
        while (head != null) {
            if ( i % 2 != 0) { // odd number
                tailOdd.next = head;
                tailOdd = head;
            } else { // even
                tailEven.next = head;
                tailEven = head;
            }
            head = head.next;
            i++;
        }
        tailOdd.next = dummyEven.next;
        tailEven.next = null;
        return dummyOdd.next;
    }
}