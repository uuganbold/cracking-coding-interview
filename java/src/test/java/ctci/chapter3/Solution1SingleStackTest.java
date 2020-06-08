package ctci.chapter3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class Solution1SingleStackTest {
    
    @Test
    public void testEmpty(){
        Solution1.SingleStack emptyStack=new Solution1.SingleStack(10);
        assertTrue(emptyStack.isEmpty());
        assertEquals(0, emptyStack.size());
        assertThrows(EmptyStackException.class, ()->{emptyStack.peek();});
        assertThrows(EmptyStackException.class, ()->{emptyStack.pop();});
    }

    @Test
    public void testPush(){
        Solution1.SingleStack stack=new Solution1.SingleStack(5);
        stack.push(10);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(10, stack.peek());
        stack.push(13);
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(13, stack.peek());
        stack.push(21);
        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(21, stack.peek());

        assertEquals(21,stack.pop());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(13, stack.peek());

        stack.push(45);
        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(45, stack.peek());


        stack.push(61);
        stack.push(72);
        assertEquals(5, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(72, stack.peek());

        assertThrows(StackOverflowError.class, ()->{stack.push(10);});
    }

    @Test
    public void testPop(){
        Solution1.SingleStack stack=new Solution1.SingleStack(10);
        stack.push(10);
        stack.push(32);
        stack.push(75);
        stack.push(98);
        stack.push(100);


        assertEquals(5, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(100, stack.peek());

        assertEquals(100, stack.pop());
        assertEquals(4, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(98, stack.peek());

        assertEquals(98, stack.pop());
        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(75, stack.peek());

        assertEquals(75, stack.pop());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(32, stack.peek());

        assertEquals(32, stack.pop());
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(10, stack.peek());

        assertEquals(10, stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertThrows(EmptyStackException.class, ()->{stack.peek();});
        assertThrows(EmptyStackException.class, ()->{stack.pop();});
    
    }


}