package gao.string;

import java.util.Scanner;

/**
 * <b>字符串分割</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/1/27 16:10
 */
public class HJ03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNext()){
            s = sc.next();
            int st = s.length()%8;
            int l = s.length()/8;
            if(l>1){
                for (int i = 0; i < l; i++) {
                    String a = s.substring(i*8, i*8+8);
                    System.out.println(a);
                }
            }
            if(st!=0){
                System.out.print(s.substring(l*8, s.length()));
                for (int i = 0; i < 8-st; i++) {
                    System.out.print(0);
                }
                System.out.println();
            }
        }

    }
}
