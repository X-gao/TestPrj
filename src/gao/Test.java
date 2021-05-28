package gao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <b>测试</b></br>
 *
 * @Company </ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/7/22 18:44
 */
public class Test {
    /**
     * str 单词+空格
     * 单词出现次数最多  多少次
     * @param args
     */
    public static void main(String[] args) {
        String str = "public static void main";
        String[] sarr = str.split(" ");
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for (int i=0;i<sarr.length;i++){
            String s = sarr[i];
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        int max = 0;
        String a = "";
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            Integer value = next.getValue();
            if(value>max){
                max=value;
                a = next.getKey();
            }
        }
        System.out.println(a);
        System.out.println(max);
    }

    @org.junit.Test
    public void testFor(){
        for (int j = 0;j<10;j++){
            double random = Math.random()*10;
            int i = (int)random;
            System.out.println("====="+i);
            for (int k = i; k < 10; k++) {
                System.out.println("--"+k);
            }
        }
    }
}
