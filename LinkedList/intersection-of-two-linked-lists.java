public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = getLenth(headA);
        int lenB = getLenth(headB);

        if (lenA > lenB) {
            return findIntersection(headB, headA, lenA - lenB);
        } else {
            return findIntersection(headA, headB, lenB - lenA);
        }
    }

    // traverse list using parent pointers to find the intersection
    private ListNode findIntersection(ListNode shorter, ListNode longer, int diff) {
        // move the lower node upside by diff levels
        while (diff > 0) {
            longer = longer.next;
            diff--;
        }
        // move two nodes until they intersect at one node or both reach null
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter; // null or the intersection
    }

    // get the height of from node to root using parent pointer
    private int getLenth(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}