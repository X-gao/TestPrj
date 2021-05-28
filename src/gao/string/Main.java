package gao.string;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

/***
 * @Author hy
 * 正解：拿空间换时间，直接创建1001长度的数组，
 *   每读取一个数，将对应的下标改为true.
 *   最后顺序输出所有为true 的下标即可
 */
public class Main {
    public static void main(String[] args) {
//       Scanner in = new Scanner(System.in);
//       String str = in.nextLine();
//       String a = in.nextLine();
//       char  letter = a.charAt(0);
//       char[] chars = str.toCharArray();
//
//       int i=0;
//       for (char c:chars) {
//            if(Character.toUpperCase(letter)==Character.toUpperCase(c)){
//                i++;
//            }
//       }
///      System.out.println(i);
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while(sc.hasNext()){
            int a = Integer.parseInt(sc.nextLine());
            int[] arr = new int[a];
            int repeatCount = 0;
            int totalCount = 0;
            for (int i = 0; i < a; i++) {
                int t = Integer.parseInt(sc.nextLine());
                //新读取数比数组任何数都大
                boolean bigger = true;
                for (int j = 0; j < i; j++) {
                    if(arr[j]==t){
                        bigger = false;
                        repeatCount++;
                        break;
                    }else if(t<arr[j]){
                        insertArr(arr,j, t);
                        totalCount++;
                        bigger = false;
                        break;
                    }
                }
                if( bigger){
                    arr[i-repeatCount] = t;
                    totalCount++;
                }
            }
            for (int i = 0; i < totalCount; i++) {
                System.out.println(arr[i]);
            }
        }

    }

    /**
     *  将数字num 插入到数组i下标的位置
     */
    private static void insertArr(int [] arr,int i,int num){
        //记录当前下标i 的值
        int temp = 0;
        temp = arr[i];
        //放入新值
        arr[i] = num;
        //将原下标i及后续值后移一位
        for (int j = i+1; j < arr.length; j++) {
            int k = arr[j];
            arr[j] = temp;
            temp = k;
        }
    }
}