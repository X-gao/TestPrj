package threadPool;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * <b>多线程，线程池</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/16 11:06
 */
public class ThreadPooL implements Runnable{
    String name;
    ThreadPooL(){

    }
    ThreadPooL(String name){
        this.name = name;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        //ThreadPooL tp = new ThreadPooL();
        //tp.wait();
        //corePoolSize : 设置线程中保留的线程数量（核心线程），maximunPoolSize: 线程池允许最大容量，keepAliveTime:多余corePoolSize 额外线程在没有活跃的情况下存活时间。
        //TimeUnit : keepAliveTime 存活时间的时间单位（秒，分等）ArrayBlockingQueue ,阻塞队列
        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(3,5, 1000L,TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),Executors.defaultThreadFactory());
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            threadpool.execute(new ThreadPooL("线程"+i));
        }
    }

    @Override
    public void run() {
            System.out.println(name+"|||线程使用线程池"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
