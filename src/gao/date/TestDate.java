package gao.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Demo class
 *
 * @author gx
 * @date 2016/10/31
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        System.out.println("Hello World!");
        Date now = new Date();
        SimpleDateFormat sd  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "2020-02-03 02:01:03";
        Date parse = sd.parse(s);
        String pattern = ".*00:00:00.*";

        System.out.println(Pattern.matches(pattern,s));
        System.out.println(parse.toString());
    }
}
