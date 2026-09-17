class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode grpprev=dummy;
        while(true){
            ListNode kth=getkthnode(grpprev,k);
            if(kth==null) break;
            ListNode grpnext=kth.next;
            ListNode prev=kth.next;
            ListNode curr=grpprev.next;
            while(curr!=grpnext){
                ListNode tmp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=tmp;
            }
            ListNode tmp=grpprev.next;
            grpprev.next=kth;
            grpprev=tmp;
        }
        return dummy.next;
    }
    private ListNode getkthnode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}