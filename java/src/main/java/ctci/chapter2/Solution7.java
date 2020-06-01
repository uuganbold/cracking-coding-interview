package ctci.chapter2;

public class Solution7 {
    
    /*
        T: O(a+b)
        S: O(1)
    */
    public static ListNode intersect(ListNode a, ListNode b){
         int sizeA=size(a);
         int sizeB=size(b);

         for(int i=0;i<sizeA-sizeB;i++){
             a=a.next;
         }

         for(int i=0;i<sizeB-sizeA;i++){
             b=b.next;
         }

         while(a!=null){
             if(a==b) return a;
             a=a.next;
             b=b.next;
         }

         return null;
    }

    private static int size(ListNode node){
        int i=0;
        while(node!=null){
            i++;
            node=node.next;
        }
        return i;
    }
}