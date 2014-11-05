package simpleTest;


import my.SubString;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.*;

/**
 * Created by Ruslan on 10/28/14.
 */
public class Homework4 {

    SubString sb = new SubString();
    String first;
    String second;

    @DataProvider
    public Object[][] filters() {
        return new Object[][] {
                new Object[] {"Start","Start"},
                new Object[] {"End","e"},
        };
    }

    @BeforeSuite
    public void fileClear() throws IOException {
        FileWriter fw = new FileWriter("test.txt");
        fw.flush();
        fw.close();
    }

    @Test(dataProvider = "filters")
    public void workWithFile(String f, String s){
        first = f;
        second = s;
        Assert.assertTrue(sb.subStr(f,s));

    }

    @AfterSuite
    public void fileWrite() throws IOException {
        FileWriter fw = new FileWriter("test.txt");
        fw.write(first + " ");
        fw.write(second);
        fw.close();
    }


}
