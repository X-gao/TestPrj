package gao.m4;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <b>括号生成</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version V1.0
 * @Author 高祥
 * @Date 2020/4/9 10:36
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
        SecureRandom random = new SecureRandom();
        long  l = random.nextLong();
        System.out.println(l);

    }


    public static List<String> generateParenthesis(int n) {
        if(n<1){
            return null;
        }
        if(n==1){
            List<String> s = new ArrayList<>();
            s.add("()");
            return s;
        }
        List<String> nArr = generateParenthesis(n-1);
        Set<String> nSet = new HashSet<>();
        if(nArr != null){
            for(int i=0;i<nArr.size();i++){
                nSet.add("()"+nArr.get(i));
                nSet.add("("+nArr.get(i)+")");
                nSet.add(nArr.get(i)+"()");
            }
        }
        nArr.clear();
        nArr.addAll(nSet);
        return nArr;
    }

}
