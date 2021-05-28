package gao.singleton;

/**
 * <b>单例</b></br>
 * 懒汉式，先不创建对象，增加判断内锁，效率增加，但是不严谨，还会有线程不安全情况
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/13 23:24
 */
public class Singleton04 {
    /**
     * 直接创建单例对象，饿汉式
     */
    private static Singleton04 instance = null;

    /**
     * 构造方法私有化，防止外部创建新对象
     */
    private Singleton04(){};

    public static Singleton04 getInstance(){
        if(instance==null){
            //有可能别的线程走到这，等待锁，同样不能够保证线程安全。
            synchronized(Singleton04.class){
                //未加锁，并发时会导致创建多个对象
                instance = new Singleton04();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(new Singleton04().hashCode());
            }).start();
        }
    }
}
