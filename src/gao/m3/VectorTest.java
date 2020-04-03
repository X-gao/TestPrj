package gao.m3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * <b>学习Vector 数组</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/3/26 15:38
 */
public class VectorTest {
    public static void main(String[] args) {

        //所有的修改操作都增加了synchronized 关键字修饰
        Vector<Integer> ve = new Vector<>();
        ve.add(2);
        System.out.println(ve);

        Date nowDate=new Date();
        SimpleDateFormat sdh = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String hourMinute=sdh.format(nowDate).substring(11);
        System.out.println(hourMinute);
    }

}
