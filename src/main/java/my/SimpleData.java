package my;



/**
 * Created by Ruslan on 10/26/14.
 */
public class SimpleData {
    public static void main(String[] args) {
        String str = "1.12345";
        double d = Double.valueOf(str);
        float f = (float) d;
        long l = (long) f;
        int i = (int) l;
        short s = (short) i;
        byte b = (byte) s;
        char ch = str.charAt(0);
        System.out.println("String -> " + str);
        System.out.println("double -> " + d);
        System.out.println("float -> " + f);
        System.out.println("long -> " + l);
        System.out.println("int -> " + i);
        System.out.println("short -> " + s);
        System.out.println("byte -> " + b);
        System.out.println("char -> " + ch);

    }
}
