package gao.string;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>创建String 会创建几个对象</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/2 8:48
 */
public class NewString {
    /**
     * fasle
     * true
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
       /* String a = "aaaaaaa";
        List<String> aa = new ArrayList<String>();
        for (int i = 0; i < 100000; i++) {
            a = a+i;
            a.intern();
            aa.add(a);
        }*/
        /*//这里会创建两个 对象，一个String, 一个常量池中的123  两个对象值都是123 但是内存地址不同，new String在堆中应该是eden
        //而123 在常量池有一个地址
        String a = new String("123");
        //调用intern 方法，常量池已经有123对象，返回对象地址，但是并没有赋值给a
        //此时a 指向堆中的String对象，而常量池有一个123没有被指向
        String intern = a.intern();
        System.out.println(System.identityHashCode(intern));//打印内存地址
        System.out.println(System.identityHashCode(a));
        //此时b创建，发现常量池已经有123，b指向常量池中123  所以a!=b
        String b = "123";
        System.out.println(System.identityHashCode(b));
        System.out.println(b==a);
        System.out.println(ClassLayout.parseInstance(a).toPrintable());


        //此时两个123在常量池中，是同一个，两个new String在堆中，不同，又创建了一个StringBuilder
        //StringBuilder 拼接完成，toString ,并创建一个新的String,拼接后的字符串没有放到常量池
        String c = new String("123")+new String("123");
        System.out.println(System.identityHashCode(c));
        Thread.sleep(1000);
        //调用intern 方法，放入常量池，其实是常量池指向了toString 返回的123123的地址
        c.intern();
        System.out.println(System.identityHashCode(c));
        //这里创建d 发现常量池有一个引用指向123123，d直接使用。所以d==c
        String d = "123123";
        System.out.println(System.identityHashCode(d));

        System.out.println(c==d);//jdk 6 false jdk7/8 true
        //jdk 6 之前常量池在方法区，调用intern 会在常量池创建一个新的对象。
        //因为jdk7/8后常量池在堆中，常量池就直接使用了之前字符串的地址，并没有新创建一个123123*/
    }
    @Test
    public void testNew(){
        String a = new String("123");
        String intern = a.intern();
        String b = "123";
        System.out.println(b==a);
        String c = new String("123")+new String("123");
        c.intern();
        String d = "123123";
        System.out.println(c==d);//jdk 6 false jdk7/8 true
    }

    @Test
    public void testAddString(){
        String a = "aaaaaaa";
        for (int i = 0; i < 10000; i++) {
            a+=i;
            a.intern();
        }
    }

    @Test
    public void testNew2(){
        int a = 1;
        String n = "1";
        String b = String.valueOf(a);
        String d = String.valueOf(a);
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(n));

        String intern = b.intern();
        d.intern();
        String c = "1";
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(intern));
        System.out.println(System.identityHashCode(d));

        System.out.println(b==c);
        System.out.println(d==c);
        System.out.println(d==b);
    }
}
