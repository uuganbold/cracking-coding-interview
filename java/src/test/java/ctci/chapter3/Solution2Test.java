package ctci.chapter3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class Solution2Test {

    @Test
    public void test(){
        Solution2 stack=new Solution2();

        assertThrows(EmptyStackException.class, ()->{stack.min();});
        
        stack.push(40);
        assertEquals(40, stack.min());

        stack.push(50);
        assertEquals(40, stack.min());

        stack.push(10);
        assertEquals(10, stack.min());

        stack.push(20);
        assertEquals(10, stack.min());

        stack.push(80);
        assertEquals(10, stack.min());

        stack.push(5);
        assertEquals(5, stack.min());

        stack.push(3);
        assertEquals(3, stack.min());

        stack.pop();
        assertEquals(5, stack.min());

        stack.pop();
        assertEquals(10, stack.min());

        stack.pop();
        assertEquals(10, stack.min());

        stack.pop();
        assertEquals(10, stack.min());

        stack.pop();
        assertEquals(40, stack.min());

        stack.pop();
        assertEquals(40, stack.min());

        stack.pop();
        assertThrows(EmptyStackException.class, ()->{stack.min();});
    }
    
}