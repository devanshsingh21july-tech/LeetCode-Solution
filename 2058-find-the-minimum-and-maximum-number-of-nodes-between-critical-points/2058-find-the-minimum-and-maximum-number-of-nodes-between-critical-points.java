class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return new int[]{-1,-1};
        }
       ListNode prev=head;
       ListNode curr=head.next;
        int firstcp=-1;
        int prevcp=-1;
        int index=1;
        int mindist=Integer.MAX_VALUE;
        while(curr.next!=null){
            ListNode next=curr.next;
            if((curr.val<prev.val&&curr.val<next.val)||(curr.val>prev.val&&curr.val>next.val)){
                if(firstcp==-1){
                    firstcp=index;
                }else{
                    mindist=Math.min(mindist,index-prevcp);
                }
                prevcp=index;
            }
            prev=curr;
            curr=curr.next;
            index++;
        }
        if(mindist==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{mindist,prevcp-firstcp};
    }
}