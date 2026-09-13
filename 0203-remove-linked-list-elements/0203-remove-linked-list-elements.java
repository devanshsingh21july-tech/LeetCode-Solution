class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val==val){
                if(prev==null){
                    head=curr.next;
                }else{
                    prev.next=curr.next;
                }
            }else{
                prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}