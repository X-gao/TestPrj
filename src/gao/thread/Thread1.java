package gao.thread;

import java.util.concurrent.Callable;

/**
 * <b>线程1</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/4/14 17:37
 */
public class Thread1 implements Callable {
    public  static Integer a = 100;

    @Override
    public String call() throws Exception {
        String result = "返回值";
        while(true){
            synchronized (this){//不能锁a对象，如果锁a,虽然内部代码做了同步，但是此时另一个线程可能已经获取到相同得a值，应该锁操作a值得对象，即
                //当前对象
                if(a>0){
                    System.out.println(Thread.currentThread().getName()+"a="+a);
                    a--;
                }else{
                    break;
                }
            }

        }
        return result;
    }
}
