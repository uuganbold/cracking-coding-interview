package ctci.chapter2;

public class Solution2 {
    /**
     *  Is it guaranteed that the list is longer than k.
     * What if it is smaller than K? return null or first node?
     */
     /*
        T: O(N)
        S: O(1)
     */
     public static Integer kthLastNode(ListNode head, int k){
        if(head==null) return null;
        assert k>0;

        ListNode slow=head;
        ListNode fast=head;

         while(k>0&&fast!=null){
             fast=fast.next;
             k--;
         }

         if(k>0) return null;

         while(fast!=null){
             fast=fast.next;
             slow=slow.next;
         }

         return slow.data;
     }

    /**
     * T: O(N)
     * S: O(N)
     */
     static int value; 
     private static int kthLastNodeRecurse(ListNode head, int k){
         if(head==null){
             return 0;
         }
         int prev=kthLastNode(head.next,k);
         if(prev==k) {
             value=k;
         }
         return prev+1;
     }

}