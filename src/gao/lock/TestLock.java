package gao.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>锁学习</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/5/21 15:21
 */
public class TestLock {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        lock.lock();
        try{
            System.out.println("打印0000");
        }finally {
            lock.unlock();
        }
    }
}
