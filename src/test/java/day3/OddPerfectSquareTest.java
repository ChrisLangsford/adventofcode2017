package day3;

import org.junit.Assert;
import org.junit.Test;

public class OddPerfectSquareTest {
    private SpiralMemoryStepCounter spiralMemoryStepCounter = new SpiralMemoryStepCounter();
    @Test
    public void perfectSquareTest(){
        Assert.assertEquals(spiralMemoryStepCounter.isOddPerfectSquare(9), true);
        Assert.assertEquals(spiralMemoryStepCounter.isOddPerfectSquare(25), true);
        Assert.assertEquals(spiralMemoryStepCounter.isOddPerfectSquare(49), true);
        Assert.assertEquals(spiralMemoryStepCounter.isOddPerfectSquare(81), true);
    }

    @Test
    public void bottomRightCornerTest(){
        Assert.assertEquals(spiralMemoryStepCounter.getBottomRightCorner(8),9);
        Assert.assertEquals(spiralMemoryStepCounter.getBottomRightCorner(17),25);
        Assert.assertEquals(spiralMemoryStepCounter.getBottomRightCorner(26),49);
    }
}
