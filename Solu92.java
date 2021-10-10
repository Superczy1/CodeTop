package CodeTop;

/**
 * AlexzyChu
 * 2021/10/10 0:07
 * <p>
 * Descripition 反转链表2
 */
public class Solu92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int step = 0;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode p = head;
        if (left == right)
            return head;
        if (left == 1){
            while(p.next != null){
                if (step == right - 1){
                    hair.next = reverse(hair.next, p);
                    return hair.next;
                }
                step++;
                p = p.next;
            }
        }
        while(p.next != null){
            if (step == left - 2){
                ListNode tail = p.next;
                step++;
                while(tail.next != null){
                    if (step == right - 1){
                        p.next = reverse(p.next, tail);
                        return head;
                    }
                    tail = tail.next;
                    step++;
                }
            }
            p = p.next;
            step++;
        }
        return hair.next;
    }
    public ListNode reverse(ListNode head, ListNode tail){
        ListNode pre = tail.next;
        ListNode p = head;
        while(pre != tail){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
