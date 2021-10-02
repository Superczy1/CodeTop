package CodeTop;

public class Solu25 {
    //25 反转k链表
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode hair = new ListNode(0);
        hair.next = head;

        int step = 0;
        ListNode p = head;
        ListNode pre = hair;
        while (p.next != null) {
            p = p.next;
            step++;
            if ((step + 1) % k == 0) {
                ListNode[] nodes = reverse(pre.next, p);
                pre.next = nodes[0];
                pre = nodes[1];
                p = nodes[1];
            }
        }
        return hair.next;
    }

    public static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        ListNode Next;
        while (pre != tail) {
            Next = p.next;
            p.next = pre;
            pre = p;
            p = Next;
        }
        return new ListNode[]{pre, head};
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int v) {
        val = v;
    }
}
