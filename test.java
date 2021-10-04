package CodeTop;

import static CodeTop.Solu206.reverseList;
import static CodeTop.Solu25.reverseKGroup;

public class test {
    public static void main(String[] args) {
        test146();
    }
    //25 k 个一组反转链表
    public static void test25(){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < 8; i++) {
            ListNode n = new ListNode(i + 1);
            p.next = n;
            p = p.next;
        }
        head = reverseKGroup(head.next, 3);
        System.out.println();
    }
    //反转链表
    public static void test206(){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < 8; i++) {
            ListNode n = new ListNode(i + 1);
            p.next = n;
            p = p.next;
        }
        head = reverseList(head.next);
        System.out.println();
    }
    //LRU
    public static void test146(){
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
