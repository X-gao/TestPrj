package gao.thread;

/**
 * <b>循环打印abc</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/4/14 17:44
 */
public class ThreadABC extends Thread{
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    @Override
    public void run() {
        threadLocal.set("1000");
        for (int i = 0; i < 10; i++) {
            System.out.println((char)(65+i));
        }
        String s = threadLocal.get();
        System.out.println(s);
        String name = this.getName();
        System.out.println(name);
    }
}
