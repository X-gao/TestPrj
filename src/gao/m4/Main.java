package gao.m4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 华为OD机试
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //单个面试官面试人次
        int m = Integer.parseInt(sc.nextLine());
        //总面试场次
        int n = Integer.parseInt(sc.nextLine());
        List<int[]> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            int s = Integer.parseInt(arr[0]);
            int e = Integer.parseInt(arr[1]);
            int[] iArr = {s,e};
            data.add(iArr);
        }
        //最大重叠次数,同一时间至少一个在面试
        int totalCount = 1;
        int c = 0;
        int other = 0;
        for (int i = 0; i <data.size(); i++) {
            int num = 1;
            int[] inti = data.get(i);
            int s = inti[0];
            int e = inti[1];
            //和当前面试重复的面试集合
            List<int[]> temp = new ArrayList<>();
            List<int[]> temp2 = new ArrayList<>();
            temp.add(inti);
            for (int j = 0; j < data.size(); j++) {
                int[] initj = data.get(j);
                int s1 = initj[0];
                int e1 = initj[1];
                int count = 0;
                for (int k = 0; k < temp.size(); k++) {
                    int[] ints = temp.get(k);
                    int ss = ints[0];
                    int se = ints[1];
                    if(!(ss>=e1 || se<=s1)){
                        count++;
                    }
                }
                //互相重叠次数最多
                if(count==temp.size()){
                    temp.add(initj);
                    num++;
                }
                if(!(s>=e1 || e<=s1)){
                    temp2.add(initj);
                }
            }
            num--;
            //单个面试者重叠最多人数
            if(temp2.size()>m){
                c += (temp2.size()-1)/m;
                other+=temp2.size()%m;
            }
            if(totalCount<num){
                totalCount = num;
            }
        }

        //不重叠情况下最少多少面试官
        int s = n/m;
        if(n%m!=0){
            s++;
        }
        totalCount+=c;
        if(other%m==0){
            totalCount+=other/m;
        }else{
            totalCount+=other/m+1;
        }
        int min  = s>totalCount?s:totalCount;
        System.out.println(min);
    }

    public static void test2(){
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String str = sc.nextLine();
        source = source.replace(" ","");
        source = source.replace("\t","");
        int count=0;
        if(str.length()<=source.length()){
            for(int i=0;i<=source.length()-str.length();i++){
                String temp = source.substring(i,i+str.length());
                if(str.equals(temp)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void test(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        //N 指令数
        int n = Integer.parseInt(arr[0]);
        //X轴终点
        int E = Integer.parseInt(arr[1]);
        //当前Y坐标
        int pointY = 0;
        //上次命令x坐标
        int preX = 0;
        long area = 0;
        for(int i=1;i<=n;i++){
            String ar = sc.nextLine();
            String[] arrXy = ar.split(" ");
            //当前X坐标
            int x = Integer.parseInt(arrXy[0]);
            //y轴偏移量
            int offsetY = Integer.parseInt(arrXy[1]);
            long thisArea = Math.abs((x-preX)*pointY);
            area+=thisArea;
            pointY = pointY+offsetY;
            preX = x;
        }
        long otherArea = Math.abs((E-preX)*pointY);
        area+=otherArea;
        System.out.println(area);
    }
}
