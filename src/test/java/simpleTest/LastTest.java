package simpleTest;

import my.Sum;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bionic on 10/22/14.
 */
public class LastTest {
    @Test
    public void lastTest(){
        int a=2;
        int b=3;
        Sum summa = new Sum();
        Assert.assertEquals(a + b +3, summa.sum(a,b));
    }
}
