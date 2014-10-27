package my;

/**
 * Created by Ruslan on 10/23/14.
 */
public class EmailValidator {

    public static boolean validatorE(String email) {
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean check = email.matches(EMAIL_REGEX);
        return  check;
    }

}
