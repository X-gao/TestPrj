package highconcurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>测试HashMap 线程安全</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/4 22:12
 */
public class TesthashMap {
    public static void main(String[] args) {
        //获得线程安全的Map
        Map<String, String> stringMap = Collections.synchronizedMap(new HashMap<String, String>(16));
    }
}
