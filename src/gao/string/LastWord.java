package gao.string;

import java.io.IOException;
import java.io.InputStream;

/**
 * <b>最后一个单词长度</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/10/19 12:47
 */
public class LastWord {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        char c = (char)in.read();
        int count = 0;
        while('\n'!=c){
            if(' '==c){
                count=0;
            }else{
                count++;
            }
            c = (char)in.read();
        }

        System.out.println(count);
    }
}
