package ctci.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2Test {
    
    @Test
    public void testNullList(){
         Assertions.assertNull(Solution2.kthLastNode(null, 10));
    }

    @Test
    public void testSingleNode(){
        ListNode head=new ListNode(10);
        Assertions.assertEquals(null, Solution2.kthLastNode(head, 2));
        Assertions.assertEquals(10, Solution2.kthLastNode(head, 1));
    }

    @Test
    public void testTooShortList(){
        ListNode head=TestUtils.buildList(new int[]{1,2,4,4,2});
        Assertions.assertEquals(null, Solution2.kthLastNode(head, 6));
    }

    @Test
    public void testLastNode(){
        ListNode head=TestUtils.buildList(new int[]{1,2,4,4,2,3});
        Assertions.assertEquals(3, Solution2.kthLastNode(head, 1));
    }

    @Test
    public void testFirstNode(){
        ListNode head=TestUtils.buildList(new int[]{1,2,4,4,2,3});
        Assertions.assertEquals(1, Solution2.kthLastNode(head, 6));
    }

    @Test
    public void testNiceCases(){
        ListNode head=TestUtils.buildList(new int[]{1,2,4,5,2,10,3});
        Assertions.assertEquals(10, Solution2.kthLastNode(head, 2));
        Assertions.assertEquals(2, Solution2.kthLastNode(head, 6));
        Assertions.assertEquals(4, Solution2.kthLastNode(head, 5));
    }


}