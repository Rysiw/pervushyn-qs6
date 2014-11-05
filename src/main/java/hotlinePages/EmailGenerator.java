package hotlinePages;

import java.util.Random;

/**
 * Created by Ruslan on 11/5/14.
 */
public class EmailGenerator {

    public static String emailGenerator(String USER_NAME, String END_EMAIL){
        Random random = new Random();
        int rage=9999;
        int generator=random.nextInt(rage);
        return USER_NAME + generator + END_EMAIL;
    }

}
