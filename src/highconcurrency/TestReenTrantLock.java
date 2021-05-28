package highconcurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>重入锁</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/2 22:11
 */
public class TestReenTrantLock extends Thread{
    ReentrantLock lock = new ReentrantLock();

    void m1() {
//      lock.tryLock();
        boolean b;
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("11111");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    void m2()  {
//        lock.tryLock();
        boolean b;
        try{
            lock.lockInterruptibly();
            try{
                System.out.println("11111");
            }catch (Exception a){
                System.out.println("aaaa");
            } finally{
                lock.unlock();
            }
        }catch (InterruptedException e){
            System.out.println("interrupt!");
        }finally {

        }

    }
    public static void main(String[] args) {
        TestReenTrantLock tl = new TestReenTrantLock();
        new Thread(tl::m1).start();
        Thread t2 = new Thread(tl::m2);
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
