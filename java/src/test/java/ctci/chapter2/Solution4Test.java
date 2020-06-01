package ctci.chapter2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Solution4Test {
    
    @Test
    public void testNullNode(){
         assertNull(Solution4.partition(null, 0));
         assertNull(Solution4.partitionWeaving(null, 0));
    }

    @Test
    public void testSingleNode(){
        ListNode head=new ListNode(15);
        TestUtils.assertListEquals(new int[]{15}, Solution4.partition(head, 15));
        TestUtils.assertListEquals(new int[]{15}, Solution4.partition(head, 10));
        TestUtils.assertListEquals(new int[]{15}, Solution4.partition(head, 20));

        TestUtils.assertListEquals(new int[]{15}, Solution4.partitionWeaving(head, 15));
        TestUtils.assertListEquals(new int[]{15}, Solution4.partitionWeaving(head, 10));
        TestUtils.assertListEquals(new int[]{15}, Solution4.partitionWeaving(head, 20));
    }

    @Test
    public void testTooSmallOrBigToPartition(){
        assertCorrectPartition(
            Solution4.partition(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 0), 
            0);
        assertCorrectPartition(
                Solution4.partition(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 80), 
                80);
        assertCorrectPartition(
            Solution4.partition(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), -1), 
            -1);
        assertCorrectPartition(
            Solution4.partition(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 79), 
            79);

        assertCorrectPartition(
            Solution4.partitionWeaving(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 0), 
            0);
        assertCorrectPartition(
                Solution4.partitionWeaving(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 80), 
                80);
        assertCorrectPartition(
            Solution4.partitionWeaving(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), -1), 
            -1);
        assertCorrectPartition(
            Solution4.partitionWeaving(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 79), 
            79);
    }

    @Test
    public void testNormalCases(){

        assertCorrectPartition(
            Solution4.partition(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 46), 
            46);
        assertCorrectPartition(
            Solution4.partition(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 3), 
            3);

        assertCorrectPartition(
            Solution4.partition(TestUtils.buildList(new int[]{4,5,8,3,3,3,46,34}), 3), 
            3);

        assertCorrectPartition(
            Solution4.partitionWeaving(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 46), 
            46);
        assertCorrectPartition(
            Solution4.partitionWeaving(TestUtils.buildList(new int[]{4,5,8,3,0,79,46,34}), 3), 
            3);

        assertCorrectPartition(
            Solution4.partitionWeaving(TestUtils.buildList(new int[]{4,5,8,3,3,3,46,34}), 3), 
            3);
    }

    private void assertCorrectPartition(ListNode head, int pivot){
        assertNotNull(head);
        boolean greator=false; 
        while(head!=null){
            assertFalse(head.data<pivot&&greator);
            if(head.data>=pivot) greator=true;
            head=head.next;    
        }
    }
}