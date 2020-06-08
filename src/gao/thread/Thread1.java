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

    @Override
    public String call() throws Exception {
        String result = "返回值";
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return result;
    }

}
