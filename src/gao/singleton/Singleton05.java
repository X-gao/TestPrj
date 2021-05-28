package gao.singleton;

/**
 * <b>单例</b></br>
 * 懒汉式，先不创建对象，增加判断内锁，效率增加，但是不严谨，还会有线程不安全情况
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/13 23:24
 */
public class Singleton05 {
    /**
     * 需要增加volatile关键字。保证线程可见。防止指令重排序，使别的线程不会读取到创建一半的对象
     */
    private static volatile Singleton05 instance = null;

    /**
     * 构造方法私有化，防止外部创建新对象
     */
    private Singleton05(){}

    public static Singleton05 getInstance(){
        if(instance==null){
            //有可能别的线程走到这，等待锁，同样不能够保证线程安全。
            synchronized(Singleton05.class){
                //锁内部再次判断，即提高了效率，又保证线程安全。
                //Double check lock  双重校验锁DCL
                if(instance==null){
                    //未加锁，并发时会导致创建多个对象
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}
