class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyhead=new ListNode(0);
        ListNode dummy=dummyhead;
        ListNode dummy1head=new ListNode(0);
        ListNode dummy1=dummy1head;
        while(head!=null){
            if(head.val<x){
                dummy.next=head;
                dummy=dummy.next;
            }else{
                dummy1.next=head;
                dummy1=dummy1.next;
            }
            head=head.next;
        }
        dummy1.next=null;
        dummy.next=dummy1head.next;
        return dummyhead.next;
    }
}