package simpleTest;

import my.EmailValidator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Ruslan on 10/23/14.
 */
public class EmailTest {
    EmailValidator e = new EmailValidator();

    @Test
    @Parameters("Email")
    public void EmTestCorrect(String Email){
        Assert.assertTrue(e.validatorE(Email));
    }

    @Test
    @Parameters("IncorrectEmail")
    public void EmTestIncorrect(String IncorrectEmail) {
        Assert.assertFalse(e.validatorE(IncorrectEmail));
    }
}
