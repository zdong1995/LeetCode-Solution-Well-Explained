class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int k = lists.length;
        // keep k pointers to merge k list, each time move next the list with smallest
        // thus we can use a min heap with size k to compare the k pointers
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k, (n1, n2) -> n1.val - n2.val);
        // initialize: add k head to the heap
        for (ListNode head : lists) {
            if (head != null) { // corner case: the k list may have null list
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // each add the smallest node to the new list, and add next node into the heap
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) { // if we added all the nodes of one list, just skip to next
                minHeap.offer(node.next);
            }
            cur.next = node;
            node.next = null;
            cur = node;
        }

        return dummy.next;
    }
}