package main.java;

/**
 * <b>创建String 会创建几个对象</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/2 8:48
 */
public class NewString {
    public static void main(String[] args) {
        String a = new String("123");
//        String a = "123";
        a.intern();
        String b = "123";
        System.out.println(b==a);

    }
}
