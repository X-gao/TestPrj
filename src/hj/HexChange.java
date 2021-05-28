package hj;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * <b>进制转换，16进制转10进制</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/4/19 22:22
 */
public class HexChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.next();

            String b = a.substring(2);
            char[] c = b.toCharArray();
            System.out.println(Integer.decode(a));

        }
        /*String a = "中";
        try {
            byte[] bytes = a.getBytes("ISO-8859-1");
            byte[] bytes1 = a.getBytes("UTF-8");
            System.out.println(bytes);
            System.out.println(bytes1);
            String b = new String(bytes,"UTF-8");
            String c = new String(bytes1,"ISO-8859-1");
            byte[] bytes2 = c.getBytes("ISO-8859-1");
            String d = new String(bytes2);
            System.out.println();
            char cc = (char)(byte)45;
            System.out.println(cc);
            byte bb = (byte)'中';
            System.out.println(bb);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/


    }
}
