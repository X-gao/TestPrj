package gao.thread;

/**
 * <b>重排序</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/12 21:34
 */
public class TestRepaixu {
    private volatile static int a = 0,b=0;
    private volatile static int x = 0,y=0;

    public static void main(String[] args) throws InterruptedException {
        int i=0;
        for (;;){
            i++;
            a = 0;b=0;
            Thread t = new Thread(new Runnable() {
                @lombok.SneakyThrows
                @Override
                public void run(){
                    x++;
                    System.out.println("T1="+ x);
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    x++;
                    System.out.println("T2="+ x);
                }
            });
            t.start();
            t2.start();
//            Thread.sleep(1000);
//            Thread.sleep(1000);
            t.join();t2.join();

            if(a!=0){
                System.out.println("第"+i+"次"+"("+a+")");
//                break;
            }else{
//                System.out.println("第"+i+"次"+"("+x+","+y+")");
            }
        }
    }
}
