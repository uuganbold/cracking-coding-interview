package ctci.chapter2;

import org.junit.jupiter.api.Test;

public class Solution3Test {
    
    @Test
    public void testNullNode(){
        Solution3.deleteMiddleNode(null);
    }

    @Test
    public void testNiceCases(){
        ListNode head=TestUtils.buildList(new int[]{3,6,2,34,8,6,2,10,3,2,4,6});
        
        ListNode six=TestUtils.findNode(head, 6);
        Solution3.deleteMiddleNode(six);
        TestUtils.assertListEquals(new int[]{3,2,34,8,6,2,10,3,2,4,6},head);

        ListNode eight=TestUtils.findNode(head, 8);
        Solution3.deleteMiddleNode(eight);
        TestUtils.assertListEquals(new int[]{3,2,34,6,2,10,3,2,4,6},head);

        ListNode four=TestUtils.findNode(head, 4);
        Solution3.deleteMiddleNode(four);
        TestUtils.assertListEquals(new int[]{3,2,34,6,2,10,3,2,6},head);

    }
}