package test2;
import java.util.*;


  class ListNode {
   int val;
   ListNode next = null;
   public ListNode(int val) {
     this.val = val;
    }
  }


public class Test {
    public static void main(String[] args) {
        Test t = new Test();

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = l;

        l = t.reverseLinkedList(l);
        System.out.println();
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode reverseLinkedList (ListNode head) {
        // write code here
        if(head==null){
            return head;
        }
        ListNode next = head.next;
        //ad.next = null;
        ListNode first = head;
        boolean circle = false;
        while(next.next!=null){
            ListNode secNext = next.next;
            next.next = head;
            head = next;
            next = secNext;
            if(next==first){
                circle = true;
                break;
            }
        }
        next.next = head;
        if(circle){
            return head;
        }else{
            head = next;
            first.next = null;
            return head;
        }
    }
}