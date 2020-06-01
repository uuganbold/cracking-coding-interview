package ctci.chapter2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class Solution5Test {
    
    @Test
    public void testNullList(){
        assertNull(Solution5.sum(null, null));
        TestUtils.assertListEquals(new int[]{2,5,3}, Solution5.sum(TestUtils.buildList(new int[]{2,5,3}), null));
        TestUtils.assertListEquals(new int[]{3,1,6}, Solution5.sum(null,TestUtils.buildList(new int[]{3,1,6})));

        assertNull(Solution5.sumWhileTraversing(null, null));
        TestUtils.assertListEquals(new int[]{2,5,3}, Solution5.sumWhileTraversing(TestUtils.buildList(new int[]{2,5,3}), null));
        TestUtils.assertListEquals(new int[]{3,1,6}, Solution5.sumWhileTraversing(null,TestUtils.buildList(new int[]{3,1,6})));
    }

    @Test
    public void testNormalCases(){
        TestUtils.assertListEquals(
            new int[]{8}, 
            Solution5.sum(
                TestUtils.buildList(new int[]{3}), 
                TestUtils.buildList(new int[]{5})
            )
        );

        TestUtils.assertListEquals(
            new int[]{2,1}, 
            Solution5.sum(
                TestUtils.buildList(new int[]{3}), 
                TestUtils.buildList(new int[]{9})
            )
        );

        TestUtils.assertListEquals(
            new int[]{0,1}, 
            Solution5.sum(
                TestUtils.buildList(new int[]{3}), 
                TestUtils.buildList(new int[]{7})
            )
        );


        TestUtils.assertListEquals(
            new int[]{1,6}, 
            Solution5.sum(
                TestUtils.buildList(new int[]{4}), 
                TestUtils.buildList(new int[]{7,5})
            )
        );

        TestUtils.assertListEquals(
            new int[]{3,0,1}, 
            Solution5.sum(
                TestUtils.buildList(new int[]{6}), 
                TestUtils.buildList(new int[]{7,9})
            )
        );

        TestUtils.assertListEquals(
            new int[]{3,5,1}, 
            Solution5.sum(
                TestUtils.buildList(new int[]{6,5}), 
                TestUtils.buildList(new int[]{7,9})
            )
        );

        TestUtils.assertListEquals(
            new int[]{3,9}, 
            Solution5.sum(
                TestUtils.buildList(new int[]{6,3}), 
                TestUtils.buildList(new int[]{7,5})
            )
        );
        
    }

    @Test
    public void testSumWhileTraversing(){
        TestUtils.assertListEquals(
            new int[]{8}, 
            Solution5.sumWhileTraversing(
                TestUtils.buildList(new int[]{3}), 
                TestUtils.buildList(new int[]{5})
            )
        );

        TestUtils.assertListEquals(
            new int[]{2,1}, 
            Solution5.sumWhileTraversing(
                TestUtils.buildList(new int[]{3}), 
                TestUtils.buildList(new int[]{9})
            )
        );

        TestUtils.assertListEquals(
            new int[]{0,1}, 
            Solution5.sumWhileTraversing(
                TestUtils.buildList(new int[]{3}), 
                TestUtils.buildList(new int[]{7})
            )
        );


        TestUtils.assertListEquals(
            new int[]{1,6}, 
            Solution5.sumWhileTraversing(
                TestUtils.buildList(new int[]{4}), 
                TestUtils.buildList(new int[]{7,5})
            )
        );

        TestUtils.assertListEquals(
            new int[]{3,0,1}, 
            Solution5.sumWhileTraversing(
                TestUtils.buildList(new int[]{6}), 
                TestUtils.buildList(new int[]{7,9})
            )
        );

        TestUtils.assertListEquals(
            new int[]{3,5,1}, 
            Solution5.sumWhileTraversing(
                TestUtils.buildList(new int[]{6,5}), 
                TestUtils.buildList(new int[]{7,9})
            )
        );

        TestUtils.assertListEquals(
            new int[]{3,9}, 
            Solution5.sumWhileTraversing(
                TestUtils.buildList(new int[]{6,3}), 
                TestUtils.buildList(new int[]{7,5})
            )
        );
    }
}