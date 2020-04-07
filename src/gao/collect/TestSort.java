package gao.collect;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static java.lang.System.*;

/**
 * @author {USER}
 * @date yyyy/MM/dd
 */
public class TestSort {
    public static void main(String[] args) {
        int [] arr = {32,21,43,78,45,12,11,55,88,90,32,12,33};
        int [] arr1 = {32,21,43,78,45,12,11,55,88,90,32,12,33};
        int start =0;
        int end = arr1.length-1;
        Date start1Time = new Date();
        insertSort(arr);
        Date startTime = new Date();
        invokeSort(arr1,start,end);
        Date endTime = new Date();
        out.println(Arrays.toString(arr));
        out.println(start1Time.getTime());
        out.println(startTime.getTime());
        new Thread( () -> out.println("In Java8, Lambda expression rocks !!") ).start();
        out.println(endTime.getTime());
        LocalDate d = LocalDate.now();
        out.println(d);

    }
    public static void invokeSort(int[] arr,int start,int end){
        int mid = quickSort(arr, start, end);
        int max = mid-1;
        if(mid>start){
            invokeSort(arr, start, max);
        }
        int min = mid+1;
        if(mid<end&&mid!=0){
            invokeSort(arr, min, end);
        }
    }
    /**
     * 插入排序
     */
    public static void insertSort(int[] arr){
        //插入排序，以第一个数字为基准，后面元素依次向前方插入到有序的位置中，
        //当最后一个元素插入到前面的部分。排序完成。
        for (int i=1;i<arr.length;i++){
            int num0 = arr[i];
            int j = i-1;
            while(j >= 0 && num0 < arr[j]){
                int temp = arr[j];
                arr[j+1] = temp;
                j--;
                arr[j+1]=num0;
            }
            arr[j+1]=num0;
        }
    }

    /**
     *@author 高祥
     *@params [arr]
     *@return void
     *@date   2020/3/10 15:40
     */
    private static int quickSort(int[] arr,int start ,int end){
        int index = 0;
        //1.取一个基准值
        int criterion  = arr[start];
        //从后向前循环和基准值对比，如果比基准值大，不做处理。end-1
        while(criterion <= arr[end] && end > start){
            end--;
        }
        //如果该值比基准值小。交换位置。
        if(criterion > arr[end] && start <= end){
            arr[start] = arr[end];
            arr[end] = criterion;
        }
        //从前向后循环对比，如果当前值比基准值小。不做处理。start+1
        while(start < end && arr[start] < criterion){
            start++;
        }
        //当前值比基准值小。交换位置
        if(start <= end && criterion < arr[start] ){
            arr[end] = arr[start];
            arr[start] = criterion;
        }
        index = start;
        if(start < end){
            index = quickSort(arr,start,end);
        }
        return index;
    }
}
