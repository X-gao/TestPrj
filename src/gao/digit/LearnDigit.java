package gao.digit;

/**
 * <b>数字交换任意两位，获得最大值</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/4/11 14:57
 */
public class LearnDigit {

    public static void main(String[] args) {
        int b = getBig(120229836);
        System.out.println(b);
    }

    public static int getBig(int b){

        String s = String.valueOf(b);
        char[] chars = s.toCharArray();
        char n = chars[0];
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]>n){
                n = chars[i];
                index = i;
            }
        }
        chars[index] = chars[0];
        chars[0] = n;
        String s1 = new String(chars);
        b = Integer.parseInt(s1);
        return b;
    }
}
