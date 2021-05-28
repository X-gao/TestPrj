package gao.singleton;

/**
 * <b>单例</b></br>
 * 最简单饿汉式
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/13 23:24
 */
public class Singleton01 {
    /**
     * 直接创建单例对象，饿汉式
     */
    private static final Singleton01 instance = new Singleton01();

    /**
     * 构造方法私有化，防止外部创建新对象
     */
    private Singleton01(){};

    public Singleton01 getInstance(){
        return instance;
    }
}
