package gao.m3;

import java.util.TreeSet;

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
        System.out.println(set);
    }
}
