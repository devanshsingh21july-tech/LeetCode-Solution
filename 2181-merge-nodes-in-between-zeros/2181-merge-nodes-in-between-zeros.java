class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode modify=head.next;
        ListNode nextadd=modify;
        while(nextadd!=null){
            int sum=0;
            while(nextadd.val!=0){
                sum+=nextadd.val;
                nextadd=nextadd.next;
            }modify.val=sum;
            nextadd=nextadd.next;
            
            modify.next=nextadd;
            modify=modify.next;
        }
        return head.next;
    }
}