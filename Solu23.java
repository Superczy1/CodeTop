package CodeTop;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * AlexzyChu
 * 2021/10/10 10:36
 * <p>
 * Descripition 合并k有序链表
 */
public class Solu23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }
        ListNode hair = new ListNode(0);
        ListNode p = hair;
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return hair.next;
    }
}
