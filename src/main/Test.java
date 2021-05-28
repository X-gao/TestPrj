package main;

import java.util.LinkedList;

/**
 * <b>测试</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2020/9/21 19:59
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<String> l1 = new  LinkedList<String>();
        LinkedList<String> l2 = new  LinkedList<String>();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String e = "e";
        l1.add(a);
        l1.add(b);
        l1.add(c);
        l2.add(d);
        l2.add(c);
        l2.add(e);
    }
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
