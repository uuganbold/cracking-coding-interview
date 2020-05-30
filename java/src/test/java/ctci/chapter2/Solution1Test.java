package ctci.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1Test {

    @Test
    public void testNullList(){
        Assertions.assertNull(Solution1.removeDuplicatesSingleSet(null));
        Assertions.assertNull(Solution1.removeDuplicatesWithoutSet(null));
    }

    @Test
    public void testSingleHead(){
        ListNode head=new ListNode(10);
        head=Solution1.removeDuplicatesSingleSet(head);
        Assertions.assertEquals(10, head.data);
        Assertions.assertNull(head.next);

        head=Solution1.removeDuplicatesWithoutSet(head);
        Assertions.assertEquals(10, head.data);
        Assertions.assertNull(head.next);
    }

    @Test
    public void testUniqueValuedList(){
         ListNode head=buildList(new int[]{1,4,6,2,3,9});
         head=Solution1.removeDuplicatesSingleSet(head);
         assertListEquals(head,new int[]{1,4,6,2,3,9});

         head=Solution1.removeDuplicatesWithoutSet(head);
         assertListEquals(head,new int[]{1,4,6,2,3,9});
    }

    @Test
    public void testDuplicatedValues(){
         ListNode head=buildList(new int[]{1,4,6,4,4,2,3,1,7,1,9,6});
         head=Solution1.removeDuplicatesSingleSet(head);
         assertListEquals(head,new int[]{1,4,6,2,3,7,9});


         head=buildList(new int[]{1,4,6,4,4,2,3,1,7,1,9,6});
         head=Solution1.removeDuplicatesWithoutSet(head);
         assertListEquals(head,new int[]{1,4,6,2,3,7,9});

    }


    private ListNode buildList(int[] values){
        ListNode head=new ListNode(values[0]);
        ListNode curr=head;
        for(int i=1;i<values.length;i++){
            curr.next=new ListNode(values[i]);
            curr=curr.next;
        }
        return head;
    }


    private void assertListEquals(ListNode head, int[] expected){
         int i=0;
         while(head!=null){
             Assertions.assertEquals(expected[i++],head.data);
             head=head.next;
         }
         Assertions.assertEquals(expected.length,i);
    }


    
}