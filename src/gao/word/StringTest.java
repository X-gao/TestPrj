package gao.word;

import java.util.Scanner;

/**
 * <b>字符串包含</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/4/11 15:34
 */
public class StringTest {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String L = sc.next();
        if(L.length()<S.length()){
            System.out.println(-1);
            return;
        }
        int j = 0;
        int i = 0;
        int index  = -1;
        for (; i < S.length();) {
            char t = S.charAt(i);
            for (;j < L.length(); j++) {
                if(L.charAt(j)==t){
                    index=j;
                    i++;
                    if(i!=S.length()){
                        j++;
                        break;
                    }
                }
            }
            if(i<S.length() && j>=L.length()){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(index);
    }*/

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        String t = "";
        int [] arri = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            byte b = (byte)arr[i];
            if(arr[i]=='-' && t==""){
                t+=arr[i];
                continue;
            }
            if(t.startsWith("-") && b>=48 && b<=57){
                t+=arr[i];
                if(i==arr.length-1){
                    arri[i]=Integer.parseInt(t);
                }
            }else if(b>=48 && b<=57){
                arri[i] = Integer.parseInt(String.valueOf(arr[i]));
            }else{
                if(!"".equals(t) && !"-".equals(t) ){
                    arri[i]=Integer.parseInt(t);
                }
                if(arr[i]=='-'){
                    t=""+arr[i];
                }else{
                    t="";
                }
            }
        }
        int sum = 0;
        for (int i=0;i<arri.length;i++){
            sum+=arri[i];
        }
        System.out.println(sum);
    }*/

   //文本统计分析
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while(sc.hasNext() ){
            String a = sc.next();
            if("1".endsWith(a)){
                break;
            }
            s+=sc.next();
        }

        s = s.replaceAll("\"&!\"*\"&!\"", "");
        String[] split = s.split(";");
        System.out.println(split.length);
    }
}
