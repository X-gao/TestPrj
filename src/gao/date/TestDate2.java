package gao.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 花月 gx
 * @date 2020 2020/2/26
 */
public class TestDate2 {
    public static void main(String[] args) {
        String d = "2020-03-04 22:03:05";
        SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR,2);
        Date time = c.getTime();
        System.out.println(time);
        System.out.println(Calendar.HOUR);

    }
}
