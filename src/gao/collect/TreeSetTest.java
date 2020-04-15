package gao.collect;

import java.util.*;

/**
 * <b>TreeSet学习</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/3/31 17:23
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(123);
        set.add(321);
        set.add(1);
        set.add(3);
        System.out.println(set.first());
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("1","2");
        treeMap.put("2","2");
        treeMap.put("3","3");
        treeMap.put("4","4");
        treeMap.put("5","5");
        treeMap.put("6","6");
        treeMap.put("7", "7");
        Map.Entry<String, String> stringStringEntry = treeMap.firstEntry();
        Map.Entry<String, String> stringStringEntry1 = treeMap.higherEntry("4");

        String s = treeMap.firstKey();
        System.out.println(stringStringEntry1);
    }
}
