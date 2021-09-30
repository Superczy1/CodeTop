package CodeHot;

public class Solu25 {
    //反转k链表
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode p = head;
        ListNode h = H;
        ListNode start = H;
        int count = 0;
        while (p.next != null) {
            p = p.next;
            count++;
            if ((count + 1) % k == 0){
                ListNode[] nodes = reverse(start.next, p);
                h.next = nodes[0];
                start = nodes[1];
                p = nodes[1];
                h = nodes[1];
            }
        }
        ListNode[] nodes = reverse(start.next, p);
        h.next = nodes[0];
        return H.next;
    }

    public static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        ListNode Next = head;
        ListNode end = tail;
        while (pre != end) {
            Next = p.next;
            p.next = pre;
            pre = p;
            p = Next;
        }
        return new ListNode[]{pre,head};
    }

    public static void main(String[] args) {
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
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int v) {
        val = v;
    }
}
