package ctci.chapter2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class Solution7Test {
     
    @Test
    public void testNullNode(){
        assertNull(Solution7.intersect(null, null));
        assertNull(Solution7.intersect(new ListNode(10), null));
        assertNull(Solution7.intersect(null, new ListNode(20)));
    }

    @Test
    public void testNotIntersect(){
        assertNull(Solution7.intersect(
            TestUtils.buildList(new int[]{1,2,3,4}), 
            TestUtils.buildList(new int[]{1,2,3,4})
        ));
    }

    @Test
    public void testIntersected(){
          ListNode a=TestUtils.buildList(new int[]{1,2,3,4,5});
          ListNode b=TestUtils.buildList(new int[]{1,2,3});
          ListNode intersect=TestUtils.buildList(new int[]{4,3,2,1});
          ListNode curr=a;
          while(curr.next!=null){
              curr=curr.next;
          }
          curr.next=intersect;

          curr=b;
          while(curr.next!=null){
              curr=curr.next;
          }
          curr.next=intersect;

          assertEquals(intersect, Solution7.intersect(a, b));

    }
}