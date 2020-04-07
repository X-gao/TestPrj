package gao.collect;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <b>linkedlist  链表学习</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/3/22 12:59
 */
public class LinkedList_3_22 {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>(2);
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);


        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1,3);

        System.out.println(arrList);
        System.out.println(list);
        System.out.println(list.size());
        Integer i1 = new Integer(130);
        Integer i2 = new Integer(2330);
        changeInteger(i1,i2);
        System.out.println(i1+"----"+i2);

        String s1 = new String("s1");
        String s2 = new String("s2");
        changeString(s1,s2);
        System.out.println(s1+"----"+s2);
    }

    static void changeInteger(Integer i1,Integer i2){
        Integer temp = i1;
        i1 = i2;
        i2 = temp;
    }
    static void changeString(String i1,String i2){
        String temp = i1;
        i1 = i2;
        i2 = temp;
    }
}
