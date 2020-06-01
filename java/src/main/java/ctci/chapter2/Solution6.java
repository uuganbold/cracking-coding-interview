package ctci.chapter2;

import java.util.Stack;
public class Solution6 {
    
    /*
        Is it elementwise or should I check the string constructed by the list?
        Singly or Doubly?
        Can I use additional data structure?
    */
    /*
        T: O(N)
        S: O(N)
    */
    public static boolean isPalindrome(ListNode node){
         Stack<Integer> stack=new Stack<>();

         ListNode slow=node;
         ListNode fast=node;

         while(fast!=null&&fast.next!=null){
             stack.push(slow.data);
             slow=slow.next;
             fast=fast.next.next;
         }

         if(fast!=null){
             slow=slow.next;
         }

         while(slow!=null){
             if(slow.data!=stack.pop()){
                 return false;
             }
             slow=slow.next;
         }

         return true;
    }
}