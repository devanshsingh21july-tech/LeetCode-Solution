class Solution {
    public ListNode mergeNodes(ListNode head) {
        // Nayi list ke liye Dummy head aur Tail pointer
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // First 0 ko skip karke Node 3 se start karo
        ListNode curr = head.next; 
        int sum = 0;

        while (curr != null) {
            if (curr.val != 0) {
                // Jab tak zero nahi aata, sum mein add karte raho
                sum += curr.val;
            } else {
                // Zero aane par naya node banao sum waali value ka
                tail.next = new ListNode(sum);
                tail = tail.next; // Tail ko naye node par shift karo
                
                sum = 0; // Agle segment ke liye sum reset karo
            }
            curr = curr.next;
        }

        return dummy.next; // Nayi list ka actual head return karo
    }
}