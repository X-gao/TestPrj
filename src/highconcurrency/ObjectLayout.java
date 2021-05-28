package highconcurrency;

import org.openjdk.jol.info.ClassLayout;

/**
 * <b>对象的内存布局</b></br>
 * manven增加依赖jol
 * <dependency>
 * <groupId>org.openjdk.jol</groupId>
 * <artifactId>jol-core</artifactId>
 * <version>0.10</version>
 * </dependency>
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/4 22:30
 */
public class ObjectLayout {
    public static void main(String[] args) {
        Object o = new Object();
        //类型布局，解析实例o ,转为可以打印输出的格式
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized(o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());


        }
    }

}
