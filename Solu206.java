package CodeTop;

public class Solu206 {
    // 迭代
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head;
        ListNode pre = null;
        while (p.next != null){
            ListNode N = p.next;
            p.next = pre;
            pre = p;
            p = N;
        }
        p.next = pre;
        return p;
    }
}
