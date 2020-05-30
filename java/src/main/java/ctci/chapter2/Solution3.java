package ctci.chapter2;

public class Solution3 {
    
    /*
        T: O(1)
        S: O(1)
    */
    public static void deleteMiddleNode(ListNode node){
         if(node==null) return;

         node.data=node.next.data;
         node.next=node.next.next;

    }
}