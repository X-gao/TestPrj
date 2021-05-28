package gao.string;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.pqc.math.linearalgebra.CharUtils;
import org.bouncycastle.util.encoders.Hex;
import org.eclipse.jetty.util.StringUtil;
import org.icepdf.core.pobjects.HexStringObject;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * <b>字符串处理</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/8/1 10:45
 */
@Transactional(rollbackFor = Exception.class)
public class LearnString {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        String str = "0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
        byte[] b = str.getBytes("utf-8");
        byte[] b1 = str.getBytes("gbk");
        byte[] b2 = str.getBytes();
        System.out.println(ByteUtils.toHexString(b));
        while(true){
//            Thread.sleep(1000000);
        }
    }
    @Test
    public void test(){
        byte[] b = {12,22};
///        CharUtils.toByteArray();
        String s = ByteUtils.toHexString(b);
        System.out.println(s);
///       byte[] bytes = s.getBytes();
        byte[] decode = Hex.decode(s);
        String a = "123";
        String c = a+"333";
        StringBuilder sb = new StringBuilder("123");
        System.out.println(sb.toString()==a);
        System.out.println(Arrays.toString(decode));

    }
    @Test
    public void testInt(){
       int a = 129;
       int b = 129;
       Integer c = 127;
       System.out.println(a==b);
       System.out.println(c==b);
       System.out.println(c.hashCode());
       Integer d=127;
       System.out.println(c==d);
    }

    private String a = new String("str");
    private char[] ch = {'a','b','c'};
    private char cha = '3';

    public void testChangeStr(String a,char[] ch,char cha){
        a = "321";
        ch[0] = 'd';
///        System.out.println(Character.hashCode(cha));
        System.out.println((byte)cha);
        cha = '落';
    }
    public void changeFinal(TestFinalString na){
//        na.a = "222";
    }
    @Test
    public void testMain(){
       /* testChangeStr(a,ch,cha);
        System.out.println(new String(ch));
        System.out.println(cha);*/
///     TestFinalString na = new TestFinalString();

        String a = "aaabbbcccaaa";
        String replace = a.replace("a", "d");
        System.out.println(replace);
        System.out.println(a);
        String s = a.replaceAll("a", "e");
        System.out.println(s);
    }

    class TestFinalString{
        public final String a = "333";
    }
}
