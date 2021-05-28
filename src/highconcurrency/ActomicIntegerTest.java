package highconcurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>原子类</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/31 22:13
 */
public class ActomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(0);
        int i = a.incrementAndGet();
        System.out.println(i);
    }
}
