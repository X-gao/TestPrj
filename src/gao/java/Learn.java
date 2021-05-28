package gao.java;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b>基本学习</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/5/27 14:32
 */
public class Learn {
    public static void main(String[] args) {
        HashMap h = new HashMap();
        System.out.println(h.size());
        ConcurrentHashMap  a = new ConcurrentHashMap(17);
        a.put("1", 2);

        System.out.println(a.size());
    }
}
