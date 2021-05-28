package gao.stack;

/**
 * <b>局部变量表</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/7/2 9:44
 */
public class LocalVeriableTest {

    public static void main(String[] args) {
        String str = "sss";
        int s = 3;
        {
            int a = 1;
            a = s-1;
        }
        System.gc();
        float b = 3.14f;
        double d = 6.18;
        long l = 111111;
        //-verbose:gc  运行时，虚拟机参数增加可以打印垃圾回收信息
        System.gc();
    }

    public String test(String arg){
        String str = "sss";
        int s = 3;
        {
            int a = 1;
            a = s-1;
        }
        float b = 3.14f;
        return "ddd";
    }
}
