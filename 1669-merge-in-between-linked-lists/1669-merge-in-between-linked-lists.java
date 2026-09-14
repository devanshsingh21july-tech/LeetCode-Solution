class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = list1;
        ListNode second = list1;
        
        // 1. (a - 1) index par aao
        for (int i = 0; i < a - 1; i++) {
            first = first.next;
        }
        
        // 2. (b + 1) index par aao
        for (int i = 0; i < b + 1; i++) {
            second = second.next;
        }
        
 
        first.next = list2;
        
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = second;
        
        return list1;
    }
}