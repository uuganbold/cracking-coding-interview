package ctci.chapter2;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    /*
        Is it doubly or singly linked list?
        Can I use extra data structure like set?

     */

     /*
        Singly Linked list using Set
        T: O(N)
        S: O(N)
     */
     public static ListNode removeDuplicatesSingleSet(ListNode  head){
           if(head==null) return null;

           Set<Integer> appeared=new HashSet<>();

           ListNode current=head;
           appeared.add(current.data);

           while(current.next!=null){
                if(appeared.contains(current.next.data)){
                    current.next=current.next.next;
                }else{
                    appeared.add(current.data);
                    current=current.next;
                }

           }

           return head;
     }

     /*
        Singly Linked list without extra memory
        T: O(N^2)
        S: O(1)
     */

     public static ListNode removeDuplicatesWithoutSet(ListNode head){
            if(head==null) return head;
            ListNode current=head;

            while(current.next!=null){
                 ListNode checkNode=current;
                 while(checkNode.next!=null){
                     if(checkNode.next.data==current.data){
                         checkNode.next=checkNode.next.next;
                     }else{
                         checkNode=checkNode.next;
                     }
                 }

                 current=current.next;
            }

            return head;

     }


     
     


  
}