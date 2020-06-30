package gao.thread;
/**
 * <b>线程学习</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/4/14 17:36
 */
public class TestThread {
    public static void main(String[] args) throws Exception {
        Thread1 t1 = new Thread1();
        ThreadABC threadABC = new ThreadABC();
        String call = t1.call();
        threadABC.start();
       /* synchronized (threadABC){
            threadABC.wait(1000);
            threadABC.notify();

        }*/
        System.out.println(call);
    }
}
