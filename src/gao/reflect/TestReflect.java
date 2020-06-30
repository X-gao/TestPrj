package gao.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * <b>测试反射</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/6/23 19:58
 */
public class TestReflect {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("gao.reflect.Person");
///         aClass = Person.class;
///         Class<? extends Person> aClass1 = new Person().getClass();
            //只能获得public 修饰的属性
            Field[] fields = aClass.getFields();
            for (Field field:fields) {
                String name = field.getName();
                System.out.println(name);
                System.out.println(field);
            }
            Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println(declaredFields.length);
            for (Field field:declaredFields) {
                String name = field.getName();
                System.out.println(name);
                System.out.println(field);
            }

            //同理 方法，构造方法的获得方式getMethod
///            aClass.getMethods();
///            aClass.getConstructors();
            //创建对象
            Person o = (Person) aClass.newInstance();
            System.out.println(o.toString());
            Constructor<?> constructor = aClass.getConstructor(String.class);
            Object o1 = constructor.newInstance("world");
            System.out.println(o1.toString());
            //获得所有注解
            Annotation[] annotations = aClass.getAnnotations();
            System.out.println(Arrays.toString(annotations));
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException |
                NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public <ET> void getEName(ET eClass){

        ET eClass1 = eClass;
    }

}
