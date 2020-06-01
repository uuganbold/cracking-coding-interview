package ctci.chapter2;

public class Solution8 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public static ListNode loopElement(ListNode node){
          ListNode slow=node;
          ListNode fast=node;

          while(fast!=null&&fast.next!=null){
              slow=slow.next;
              fast=fast.next.next;
              if(slow==fast){
                  while(slow!=node){
                      slow=slow.next;
                      node=node.next;
                  }
                  return node;
              }
          }

         return null;
    }
}