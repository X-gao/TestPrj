package gao.singleton;

/**
 * <b>单例</b></br>
 * 懒汉式，先不创建对象，但是加方法级锁，线程安全，但是效率低
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/13 23:24
 */
public class Singleton03 {
    /**
     * 懒汉式，增加synchronized
     */
    private static Singleton03 instance = null;

    /**
     * 构造方法私有化，防止外部创建新对象
     */
    private Singleton03(){};

    /**
     * 方法直接加锁，线程安全，效率低
     * @return
     */
    public static synchronized Singleton03 getInstance(){
        if(instance!=null){
            return instance;
        }else{
            //未加锁，并发时会导致创建多个对象
            instance = new Singleton03();
        }
        return instance;
    }
}
