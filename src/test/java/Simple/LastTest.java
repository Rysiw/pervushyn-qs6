package Simple;

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
        Assert.assertTrue(a + b == summa.sum(a,b));
    }
}