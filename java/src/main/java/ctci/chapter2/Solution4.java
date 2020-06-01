package ctci.chapter2;

public class Solution4 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public static ListNode partition(ListNode head, int pivot){
         ListNode smaller=new ListNode(0);
         ListNode greator=new ListNode(0);

         ListNode smallerTail=smaller;
         ListNode greatorTail=greator;
         while(head!=null){
             if(head.data<pivot){
                 smallerTail.next=head;
                 smallerTail=smallerTail.next;
             }else{
                 greatorTail.next=head;
                 greatorTail=greatorTail.next;
             }
             head=head.next;
         }
         greatorTail.next=null;

         smallerTail.next=greator.next;
         return smaller.next;
    }

    /*
        T: O(N)
        S: O(1)
    */
    public static ListNode partitionWeaving(ListNode node, int x){
        if(node==null) return null;
        ListNode head=node;
        ListNode tail=node;

        while(node!=null){
            ListNode next=node.next;
            if(node.data<x){
                node.next=head;
                head=node;
            }else{
                tail.next=node;
                tail=node;
            }
            node=next;
        }

        tail.next=node;
        return head;
    }
}