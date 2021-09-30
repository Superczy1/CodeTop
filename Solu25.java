package CodeHot;

public class Solu25 {
    //反转k链表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode p = head;
        int count = 0;
        while(p != null){
            p = p.next;
            count ++;
        }
        return head;
    }

}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int v){
        val = v;
    }
}
