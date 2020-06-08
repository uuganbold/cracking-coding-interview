package ctci.chapter3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution3Test {
     
    @Test
    public void test(){

        Solution3 stack=new Solution3(4);

        assertEquals(0, stack.getSetSize());
        assertEquals(0, stack.size());

        stack.push(10);
        assertEquals(1, stack.getSetSize());
        assertEquals(1, stack.size());

        stack.push(1);
        stack.push(4);
        stack.push(7);
        assertEquals(1, stack.getSetSize());
        assertEquals(4, stack.size());

        stack.push(15);
        assertEquals(2, stack.getSetSize());
        assertEquals(5, stack.size());

        stack.push(17);
        stack.push(28);
        stack.push(45);
        assertEquals(2, stack.getSetSize());
        assertEquals(8, stack.size());

        stack.push(25);
        assertEquals(3, stack.getSetSize());
        assertEquals(9, stack.size());

        stack.push(23);
        stack.push(21);
        stack.push(56);
        stack.push(45);
        assertEquals(4, stack.getSetSize());
        assertEquals(13, stack.size());


        assertEquals(45, stack.pop());
        assertEquals(3, stack.getSetSize());
        assertEquals(12, stack.size());

        assertEquals(56, stack.pop());
        assertEquals(3, stack.getSetSize());
        assertEquals(11, stack.size());

        assertEquals(21, stack.pop());
        assertEquals(3, stack.getSetSize());
        assertEquals(10, stack.size());

        
        assertEquals(7, stack.popAt(0));
        assertEquals(3, stack.getSetSize());
        assertEquals(9, stack.size());

        assertEquals(4, stack.popAt(0));
        assertEquals(3, stack.getSetSize());
        assertEquals(8, stack.size());

        assertEquals(1, stack.popAt(0));
        assertEquals(3, stack.getSetSize());
        assertEquals(7, stack.size());
        
        assertEquals(10, stack.popAt(0));
        assertEquals(2, stack.getSetSize());
        assertEquals(6, stack.size());

        assertEquals(23, stack.pop());
        assertEquals(2, stack.getSetSize());
        assertEquals(5, stack.size());

        assertEquals(25, stack.popAt(1));
        assertEquals(1, stack.getSetSize());
        assertEquals(4, stack.size());

        assertEquals(45, stack.popAt(0));
        assertEquals(1, stack.getSetSize());
        assertEquals(3, stack.size());
    }
}