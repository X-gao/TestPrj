package highconcurrency;

import java.util.concurrent.Semaphore;

/**
 * <b>信号量，限流</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/4 21:44
 */
public class TestSemaPhore {
    public static void main(String[] args) {
        Semaphore sp = new Semaphore(6);
    }
}
