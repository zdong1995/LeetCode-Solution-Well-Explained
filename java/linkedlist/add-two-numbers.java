class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int digitSum = carry;
            if (l1 != null) {
                digitSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                digitSum += l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode((digitSum % 10));
            tail = tail.next;
            carry = digitSum >= 10 ? 1 : 0;
        }
     
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
}