package gao.m4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串转int
 * @author 高祥
 * @return
 * @date   2020/4/3 9:21
 */
class Solution {
    public static Pattern pattern = Pattern.compile("^(\\+|-)?\\d+");

    public static void main(String[] args) {
        String str = " -+123a";
//        int a = myAtoi(str);
        str = str.trim();
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            System.out.println("匹配到");
            String group = matcher.group();
            System.out.println(group);
        }
        System.out.println();
    }

    /**
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     *
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
     * 则你的函数不需要进行转换，即无法进行有效转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     *
     * 提示：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
     * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //字符串为空，返回0
        if("".equals(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        int index = 0;
        int digit = -1;
        //便利字符数组，如果是空字符串就校验下一个，首个非空字符如果符合数字判定条件。就跳出循环。不符合就返回0
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c==' '){
                continue;
            }
            if(c=='-'||c=='+'||(c>=48 && c<=57)){
                digit = i;
                break;
            }else{
                break;
            }
        }
        if(digit==-1){
            return 0;
        }
        //获得后续连续符合数字判定的字符下标。直到遇到不符合条件
        for (int i = digit+1; i < chars.length; i++) {
            char c = chars[i];
            if(c<48 || c>57){
                index=i;
                break;
            }
        }
        int ret = 0;
        try {
            if(index==0){
               index = str.length();
            }
            if(chars[digit]=='-'||chars[digit]=='+'){
               if(index-digit<=1){
                   return 0;
               }
            }
            ret = Integer.parseInt(str.substring(digit,index));
        } catch (NumberFormatException e) {
            if(chars[digit]=='-'){
                return Integer.MIN_VALUE;
            }
           return Integer.MAX_VALUE;
        }
        return ret;
    }
    public static int myAtoiRegex(String str) {
        str = str.trim();
        if("".equals(str)){
            return 0;
        }
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            System.out.println("匹配到");
            String group = matcher.group();
            try {
                int result = Integer.parseInt(group);
                return result;
            } catch (NumberFormatException e) {
                return group.startsWith("-")?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }

        }else{
            return 0;
        }
    }
}