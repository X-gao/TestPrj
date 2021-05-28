package hj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * <b></b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/5/7 21:33
 */
public class Zhishuyinzi {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long p = l/2;
        for (long i = 2; i <=l/2; i++) {
            long a = l%i;
            if(a==0){
                System.out.print(i+" ");
                l/=i;
                i--;
            }
        }
        System.out.print(l+" ");
    }
}
