package highconcurrency;

/**
 * <b>测试volatile关键字</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/13 8:46
 */
public class TestVolatile {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println("线程启动a值为："+myData.a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.changeA();
            System.out.println("线程结束a值为："+myData.a);
        }).start();
        //如果读取不到最新的a值，这里会死循环。
        while (myData.a==0){
            //循环里不能写代码，不然不增加volatile也能读取最新的a值，猜想这里的操作导致while循环重新读取了a的值
            /* try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
//            System.out.println(myData.a);
        }
        System.out.println("a的值改变，并且被主线程看到");
    }
}

class MyData{
    //设置 volatile,static,和不加关键字。只有volatile能达到线程可见性。
//    static int a = 0;
    volatile int a = 0;
//    int a = 0;

    void changeA(){
        a = 10;
    }
}