package gao;

/**
 * <b>方法区</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/2 23:22
 */
public class MethodAreaTest {
    public static long i=10L;
    public static void main(String[] args) {

//        String test = "123";
//        System.out.println("start....");
        new MethodAreaTest();
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
