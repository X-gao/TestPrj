package gao.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>学习堆内存</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/7/14 17:14
 */
public class TestHeap {
    public static void main(String[] args) throws InterruptedException {

       /* int i = 10;
        System.out.println(i);
        Map<String,Object> a = new HashMap<>();
        if(true){
            TestHeap s = new TestHeap();
            a.put("key",s);
            s = null;
        }
        System.out.println(a.get("key"));*/
        long l = System.currentTimeMillis();
        for (int j = 0; j < 10000; j++) {
            createObject();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-l+"ms");
        Thread.sleep(1000000);
    }

    static void createObject(){
        User o = new User();
        o.name="aaa";
        o.age=12;
        System.out.println(o.name+"---"+o.age);
    }
    static class User{
        String name;
        int age;
    }

}
