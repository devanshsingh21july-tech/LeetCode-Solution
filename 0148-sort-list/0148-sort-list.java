class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Total length nikalna
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step size: 1, 2, 4, 8...
        for (int step = 1; step < length; step *= 2) {
            ListNode prev = dummy;
            curr = dummy.next;

            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, step);
                curr = split(right, step);

                prev.next = merge(left, right);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return dummy.next;
    }

    // List ko 'step' size par break karne ka helper
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        ListNode second = head.next;
        head.next = null; // Break connection
        return second;
    }

    // Two sorted lists ko merge karne ka basic pointer method
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}