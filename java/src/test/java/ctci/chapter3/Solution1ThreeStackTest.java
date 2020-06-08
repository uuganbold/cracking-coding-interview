package ctci.chapter3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class Solution1ThreeStackTest {
    @Test
    public void testEmpty(){
        Solution1.ThreeStack emptyStack=new Solution1.ThreeStack(10);
        assertTrue(emptyStack.isEmpty(0));
        assertTrue(emptyStack.isEmpty(1));
        assertTrue(emptyStack.isEmpty(2));
        assertEquals(0, emptyStack.size(0));
        assertEquals(0, emptyStack.size(1));
        assertEquals(0, emptyStack.size(2));
        assertThrows(EmptyStackException.class, ()->{emptyStack.peek(0);});
        assertThrows(EmptyStackException.class, ()->{emptyStack.pop(0);});

        assertThrows(EmptyStackException.class, ()->{emptyStack.peek(1);});
        assertThrows(EmptyStackException.class, ()->{emptyStack.pop(1);});

        assertThrows(EmptyStackException.class, ()->{emptyStack.peek(2);});
        assertThrows(EmptyStackException.class, ()->{emptyStack.pop(2);});
    }

    @Test
    public void testPush(){
        Solution1.ThreeStack stack=new Solution1.ThreeStack(10);
        stack.push(0, 10);
        /**
         * S0: 10
         * S1:
         * S2:
         */
        assertEquals(1, stack.size(0));
        assertFalse(stack.isEmpty(0));
        assertEquals(10, stack.peek(0));
        assertTrue(stack.isEmpty(1));
        assertTrue(stack.isEmpty(2));

        /**
         * S0: 10
         * S1: 13
         * S2:
         */
        stack.push(1,13);
        assertEquals(1, stack.size(1));
        assertFalse(stack.isEmpty(1));
        assertEquals(13, stack.peek(1));
        assertFalse(stack.isEmpty(0));
        assertTrue(stack.isEmpty(2));

        /**
         * S0: 10, 21
         * S1: 13
         * S2:
         */
        stack.push(0,21);
        assertEquals(2, stack.size(0));
        assertFalse(stack.isEmpty(0));
        assertEquals(21, stack.peek(0));
        assertEquals(13, stack.peek(1));
        assertTrue(stack.isEmpty(2));
        /**
         * S0: 10, 21, 56
         * S1: 13
         * S2:
         */
        stack.push(0,56);
        assertEquals(3, stack.size(0));
        assertFalse(stack.isEmpty(0));
        assertEquals(56, stack.peek(0));
        assertEquals(13, stack.peek(1));
        assertTrue(stack.isEmpty(2));
        /**
         * S0: 10, 21, 56
         * S1: 13
         * S2: 11
         */
        stack.push(2,11);
        assertEquals(1, stack.size(2));
        assertFalse(stack.isEmpty(2));
        assertEquals(56, stack.peek(0));
        assertEquals(13, stack.peek(1));
        assertEquals(11, stack.peek(2));
        /**
         * S0: 10, 21, 56
         * S1: 13
         * S2: 11, 10
         */
        stack.push(2,10);
        assertEquals(2, stack.size(2));
        assertFalse(stack.isEmpty(2));
        assertEquals(56, stack.peek(0));
        assertEquals(13, stack.peek(1));
        assertEquals(10, stack.peek(2));
        /**
         * S0: 10, 21, 56
         * S1: 13, 10
         * S2: 11, 10
         */
        stack.push(1,10);
        assertEquals(2, stack.size(1));
        assertFalse(stack.isEmpty(1));
        assertEquals(56, stack.peek(0));
        assertEquals(10, stack.peek(1));
        assertEquals(10, stack.peek(2));
        /**
         * S0: 10, 21, 56
         * S1: 13, 10, 20
         * S2: 11, 10
         */
        stack.push(1,20);
        assertEquals(3, stack.size(1));
        assertFalse(stack.isEmpty(1));
        assertEquals(56, stack.peek(0));
        assertEquals(20, stack.peek(1));
        assertEquals(10, stack.peek(2));
        /**
         * S0: 10, 21
         * S1: 13, 10, 20
         * S2: 11, 10
         */
        assertEquals(56,stack.pop(0));
        assertEquals(2,stack.size(0));
        assertEquals(21, stack.peek(0));
        assertEquals(20, stack.peek(1));
        assertEquals(10, stack.peek(2));
        /**
         * S0: 10, 21
         * S1: 13, 10, 20, 20 
         * S2: 11, 10
         */
        stack.push(1,20);
        assertEquals(4, stack.size(1));
        assertFalse(stack.isEmpty(1));
        assertEquals(21, stack.peek(0));
        assertEquals(20, stack.peek(1));
        assertEquals(10, stack.peek(2));

        /**
         * S0: 10, 21
         * S1: 13, 10, 20, 20, 40
         * S2: 11, 10
         */
        stack.push(1,40);
        assertEquals(5, stack.size(1));
        assertFalse(stack.isEmpty(1));
        assertEquals(21, stack.peek(0));
        assertEquals(40, stack.peek(1));
        assertEquals(10, stack.peek(2));

        /**
         * S0: 10, 21, 32
         * S1: 13, 10, 20, 20, 40
         * S2: 11, 10
         */
        stack.push(0,32);
        assertEquals(3, stack.size(0));
        assertFalse(stack.isEmpty(0));
        assertEquals(32, stack.peek(0));
        assertEquals(40, stack.peek(1));
        assertEquals(10, stack.peek(2));

        assertThrows(StackOverflowError.class, ()->{stack.push(0,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(1,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(2,10);});
    }

    @Test
    public void testPushToOneStack(){
        Solution1.ThreeStack stack=new Solution1.ThreeStack(4);
        stack.push(0,32);
        stack.push(0,10);
        stack.push(0,32);
        stack.push(0,10);
        assertEquals(4, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(0, stack.size(2));

        assertThrows(StackOverflowError.class, ()->{stack.push(0,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(1,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(2,10);});

        stack.pop(0);
        stack.pop(0);
        stack.pop(0);
        stack.pop(0);

        stack.push(1,32);
        stack.push(1,10);
        stack.push(1,32);
        stack.push(1,10);
        assertEquals(0, stack.size(0));
        assertEquals(4, stack.size(1));
        assertEquals(0, stack.size(2));

        assertThrows(StackOverflowError.class, ()->{stack.push(0,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(1,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(2,10);});

        stack.pop(1);
        stack.pop(1);
        stack.pop(1);
        stack.pop(1);

        stack.push(2,32);
        stack.push(2,10);
        stack.push(2,32);
        stack.push(2,10);
        assertEquals(0, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(4, stack.size(2));

        assertThrows(StackOverflowError.class, ()->{stack.push(0,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(1,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(2,10);});
    }

    @Test
    public void testPushToTwoStack(){
        Solution1.ThreeStack stack=new Solution1.ThreeStack(4);
        stack.push(0,32);
        stack.push(0,10);
        stack.push(1,32);
        stack.push(1,10);
        assertEquals(2, stack.size(0));
        assertEquals(2, stack.size(1));
        assertEquals(0, stack.size(2));

        assertThrows(StackOverflowError.class, ()->{stack.push(0,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(1,10);});
        assertThrows(StackOverflowError.class, ()->{stack.push(2,10);});
    }

    @Test
    public void testPop(){
        Solution1.ThreeStack stack=new Solution1.ThreeStack(10);
        stack.push(0,10);
        stack.push(0,32);
        stack.push(0,75);
        stack.push(1,98);
        stack.push(1,100);
        stack.push(2,1);
        stack.push(2,3);
        stack.push(2,10);


        assertEquals(3, stack.size(0));
        assertEquals(2, stack.size(1));
        assertEquals(3, stack.size(2));
        assertFalse(stack.isEmpty(0));
        assertFalse(stack.isEmpty(1));
        assertFalse(stack.isEmpty(2));
        assertEquals(75, stack.peek(0));
        assertEquals(100, stack.peek(1));
        assertEquals(10, stack.peek(2));

        assertEquals(75, stack.pop(0));
        assertEquals(2, stack.size(0));
        assertEquals(2, stack.size(1));
        assertEquals(3, stack.size(2));
        assertFalse(stack.isEmpty(0));
        assertFalse(stack.isEmpty(1));
        assertFalse(stack.isEmpty(2));
        assertEquals(32, stack.peek(0));
        assertEquals(100, stack.peek(1));
        assertEquals(10, stack.peek(2));

        assertEquals(100, stack.pop(1));
        assertEquals(2, stack.size(0));
        assertEquals(1, stack.size(1));
        assertEquals(3, stack.size(2));
        assertFalse(stack.isEmpty(0));
        assertFalse(stack.isEmpty(1));
        assertFalse(stack.isEmpty(2));
        assertEquals(32, stack.peek(0));
        assertEquals(98, stack.peek(1));
        assertEquals(10, stack.peek(2));

        assertEquals(98, stack.pop(1));
        assertEquals(2, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(3, stack.size(2));
        assertFalse(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertFalse(stack.isEmpty(2));
        assertEquals(32, stack.peek(0));
        assertThrows(EmptyStackException.class, ()->{stack.peek(1);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(1);});
        assertEquals(10, stack.peek(2));

        assertEquals(32, stack.pop(0));
        assertEquals(1, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(3, stack.size(2));
        assertFalse(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertFalse(stack.isEmpty(2));
        assertEquals(10, stack.peek(0));
        assertThrows(EmptyStackException.class, ()->{stack.peek(1);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(1);});
        assertEquals(10, stack.peek(2));

        assertEquals(10, stack.pop(0));
        assertEquals(0, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(3, stack.size(2));
        assertTrue(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertFalse(stack.isEmpty(2));
        assertThrows(EmptyStackException.class, ()->{stack.peek(0);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(0);});
        assertThrows(EmptyStackException.class, ()->{stack.peek(1);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(1);});
        assertEquals(10, stack.peek(2));

        
        assertEquals(10, stack.pop(2));
        assertEquals(0, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(2, stack.size(2));
        assertTrue(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertFalse(stack.isEmpty(2));
        assertThrows(EmptyStackException.class, ()->{stack.peek(0);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(0);});
        assertThrows(EmptyStackException.class, ()->{stack.peek(1);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(1);});
        assertEquals(3, stack.peek(2));

        assertEquals(3, stack.pop(2));
        assertEquals(1, stack.pop(2));
        assertEquals(0, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(0, stack.size(2));
        assertTrue(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertTrue(stack.isEmpty(2));
        assertThrows(EmptyStackException.class, ()->{stack.peek(0);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(0);});
        assertThrows(EmptyStackException.class, ()->{stack.peek(1);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(1);});
        assertThrows(EmptyStackException.class, ()->{stack.peek(2);});
        assertThrows(EmptyStackException.class, ()->{stack.pop(2);});

    
    }
}