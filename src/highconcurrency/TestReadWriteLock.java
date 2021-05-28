package highconcurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <b>读写锁</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/4 21:24
 */
public class TestReadWriteLock {

    ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            Thread t = new Thread(()->{
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        while (true){

        }
    }
}
