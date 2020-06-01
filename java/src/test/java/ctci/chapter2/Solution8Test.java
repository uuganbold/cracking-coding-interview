package ctci.chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Solution8Test {
    

    @Test
    public void testNullList(){
        assertNull(Solution8.loopElement(null));
    }

    @Test
    public void testSingleNode(){
        ListNode head=new ListNode(0);
        assertEquals(null, Solution8.loopElement(head));

        head.next=head;
        assertEquals(head, Solution8.loopElement(head));
    }

    @Test
    public void testSelfPointing(){
        ListNode head=TestUtils.buildList(new int[]{1,2,3,4});
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=curr;

        assertEquals(curr, Solution8.loopElement(head));
    }

    @Test
    public void testPerfectCircle(){
        ListNode head=TestUtils.buildList(new int[]{1,2,3,4});
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;

        assertEquals(head, Solution8.loopElement(head));
    }

    @Test
    public void testNormalCase(){
        ListNode head=TestUtils.buildList(new int[]{1,2,3,4,5,6});
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }

        ListNode three=head.next.next;
        curr.next=three;

        assertEquals(three, Solution8.loopElement(head));
    }

    @Test
    public void testNotCircle(){
        ListNode head=TestUtils.buildList(new int[]{1,2,3,4,5,6});

        assertEquals(null, Solution8.loopElement(head));
    }
}