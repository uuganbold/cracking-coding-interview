package ctci.chapter2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Solution6Test {
    
    @Test
    public void testNullList(){
        assertTrue(Solution6.isPalindrome(null));
    } 

    @Test
    public void testSingleNode(){
        assertTrue(Solution6.isPalindrome(new ListNode(5)));
    }

    @Test
    public void testEvenNodes(){
        assertTrue(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,1})));
        assertFalse(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,2})));
        assertTrue(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,4,4,1})));
        assertFalse(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,4,4,3})));
        assertFalse(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,4,3,1})));
    }

    @Test
    public void testOddNodes(){
        assertTrue(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,2,1})));
        assertFalse(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,2,2})));
        assertTrue(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,4,5,4,1})));
        assertFalse(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,4,5,4,3})));
        assertFalse(Solution6.isPalindrome(TestUtils.buildList(new int[]{1,4,5,3,1})));
    }
    
}