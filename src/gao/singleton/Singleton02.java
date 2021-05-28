package gao.singleton;

/**
 * <b>单例</b></br>
 * 懒汉式，先不创建对象
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/13 23:24
 */
public class Singleton02 {
    /**
     * 用到在创建对象
     */
    private static Singleton02 instance = null;

    /**
     * 构造方法私有化，防止外部创建新对象
     */
    private Singleton02(){};

    public static Singleton02 getInstance(){
        if(instance!=null){
            return instance;
        }else{
            //未加锁，并发时会导致创建多个对象
            instance = new Singleton02();
        }
        return instance;
    }
}
