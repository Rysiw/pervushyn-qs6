package my;

/**
 * Created by Ruslan on 10/28/14.
 */
public class SubString {

    public static boolean subStr (String first, String second){
        if (first.indexOf(second) != -1){
            return true;
        } else {
            return false;
        }
    }
}
