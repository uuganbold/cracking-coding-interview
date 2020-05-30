package ctci.chapter2;

import org.junit.jupiter.api.Assertions;

public class TestUtils {
    public static ListNode buildList(int[] values){
        ListNode head=new ListNode(values[0]);
        ListNode curr=head;
        for(int i=1;i<values.length;i++){
            curr.next=new ListNode(values[i]);
            curr=curr.next;
        }
        return head;
    }


    public static void assertListEquals(int[] expected, ListNode actual){
         int i=0;
         while(actual!=null){
             Assertions.assertEquals(expected[i++],actual.data);
             actual=actual.next;
         }
         Assertions.assertEquals(expected.length,i);
    }

    public static ListNode findNode(ListNode head, int value){
        while(head!=null){
            if(head.data==value) return head;
            head=head.next;
        }
        return null;
    }
}