package highconcurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>固定容量同步容器</b></br>
 * 多个消费者多个生产者，同时运行的安全容器。
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/10 21:29
 */
public class SynContainer {
    int size = 0;
    static int MAX_SIZE = 10;
    private LinkedList<Object> list = new LinkedList<Object>();

    /**
     * 消费者消费方法
     */
    public synchronized Object get(){
        if(size==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object last = list.removeLast();
        size--;
        notifyAll();
        String name = Thread.currentThread().getName();
        System.out.println(name+"消费--"+last+"==剩余："+getCount());
        return last;
    }

    /**
     * 生产者向容器添加
     * @param o
     */
    private synchronized void put(Object o){
        //容器满了，读线程等待
        if(size==MAX_SIZE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        list.add(o);
        size++;
        String name = Thread.currentThread().getName();
        System.out.println(name+"添加--"+o+"==剩余："+getCount());
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private synchronized int getCount(){
        return size;
    }

    public static void main(String[] args) {
        SynContainer sc = new SynContainer();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                String s = i+"p1";
                sc.put(s);
            }
        },"producer2").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                String s = i+"p2";
                sc.put(s);

            }
        },"producer1").start();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 2; j++) {
                    sc.get();
                }
            },"consumer+"+i).start();
        }
    }
}
