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
    public static String naStr = "333";
    public static void main(String[] args) throws ParseException {
        System.out.println("Hello World!");
        //取操作系统当前时间，服务器操作系统时间不一致可能会导致应用之间出现异常数据
        //因此要做服务器之间的时间同步
        Date now = new Date();
        SimpleDateFormat sd  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "2020-02-03 02:01:03";
        Date parse = sd.parse(s);
        String pattern = ".*00:00:00.*";
        String format = sd.format(now);
        System.out.println(Pattern.matches(pattern,s));
        System.out.println(parse.toString());
        System.out.println(format);
        System.out.println(naStr);
        System.gc();

        System.out.println(parse.after(new Date()));
    }
}
