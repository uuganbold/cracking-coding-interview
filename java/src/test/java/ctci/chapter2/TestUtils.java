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


    public static void assertListEquals(ListNode head, int[] expected){
         int i=0;
         while(head!=null){
             Assertions.assertEquals(expected[i++],head.data);
             head=head.next;
         }
         Assertions.assertEquals(expected.length,i);
    }
}