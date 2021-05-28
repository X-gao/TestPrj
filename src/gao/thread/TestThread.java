package gao.thread;

import java.util.concurrent.*;

/**
 * <b>线程学习</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/4/14 17:36
 */
public class TestThread {
    static int i=0;

    public static void main(String[] args) throws Exception {
        int a = 0;
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        ThreadABC threadABC = new ThreadABC();
        threadABC.interrupt();

//        String call = t1.call();
//        threadABC.start();
//        synchronized (threadABC){
//            threadABC.wait(1000);
//            threadABC.notify();
//
//        }
//        System.out.println(call);
        FutureTask<Integer> futureTask = new FutureTask<>(t1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(t2);
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        ThreadPoolExecutor p = new ThreadPoolExecutor(2,10,2,null, null);

        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
