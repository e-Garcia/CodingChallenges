package ga.egarcia.codingchallenges.solutions;

import static org.junit.Assert.assertArrayEquals;

import junit.framework.TestCase;

import org.junit.Test;

public class TwoSumTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testSimple_test() {
        final int[] sampleData = new int[] {3,2,4};
        final int sampleTarget = 6;
        final int[] expectedResult = new int[] {1,2};

        final int[] result = TwoSum.twoSum(sampleData, sampleTarget);

        assertArrayEquals(expectedResult, result);
    }
}