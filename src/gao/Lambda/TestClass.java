package gao.Lambda;

/**
 * <b>测试Lambda</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/20 21:31
 */
public class TestClass {
    public static void main(String[] args) {
        TestInnterface testInnterface = new TestInnterface() {
            @Override
            public void start() {

            }

            @Override
            public void start2() {

            }
        };
        Runnable runnable = () -> {
            
        };
    }
}
