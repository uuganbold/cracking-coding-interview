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
         ListNode head=TestUtils.buildList(new int[]{1,4,6,2,3,9});
         head=Solution1.removeDuplicatesSingleSet(head);
         TestUtils.assertListEquals(head,new int[]{1,4,6,2,3,9});

         head=Solution1.removeDuplicatesWithoutSet(head);
         TestUtils.assertListEquals(head,new int[]{1,4,6,2,3,9});
    }

    @Test
    public void testDuplicatedValues(){
         ListNode head=TestUtils.buildList(new int[]{1,4,6,4,4,2,3,1,7,1,9,6});
         head=Solution1.removeDuplicatesSingleSet(head);
         TestUtils.assertListEquals(head,new int[]{1,4,6,2,3,7,9});


         head=TestUtils.buildList(new int[]{1,4,6,4,4,2,3,1,7,1,9,6});
         head=Solution1.removeDuplicatesWithoutSet(head);
         TestUtils.assertListEquals(head,new int[]{1,4,6,2,3,7,9});

    }


   


    
}