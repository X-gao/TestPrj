package gao.reflect;

import java.lang.reflect.Field;

/**
 * <b>学习反射</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/6/23 19:49
 */
public class Person {
    public String firstName;
    private String name;
    private int age;

    private void eat(){
        System.out.println("吃");
    }

    public Person(){

    }

    public Person(String name){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
