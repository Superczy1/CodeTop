package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * AlexzyChu
 * 2021/10/3 16:11
 * <p>
 * Descripition
 */
public class LRUCache {
    class DLinkedNode{
       int key;
       int val;
       DLinkedNode pre;
       DLinkedNode next;
       public DLinkedNode(){}
       public DLinkedNode(int key, int val){
           this.key = key;
           this.val = val;
       }
    }
    private Map<Integer, DLinkedNode> cache;
    private int capicity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int c){
        capicity = c;
        size = 0;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        if (cache.containsKey(key)){
            moveTohead(key);
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value){
        if (cache.containsKey(key)){
            update(key, value);
            return;
        }
        if (size < capicity){
            addToHead(key, value);
            size++;
            return;
        }
        delete();
        addToHead(key, value);
    }
    public void moveTohead(int key){
        DLinkedNode node = cache.get(key);
        delete(key);
        addToHead(node.key, node.val);
    }
    public void addToHead(int key, int value){
        DLinkedNode node = new DLinkedNode(key, value);
        cache.put(key, node);
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    public void update(int key, int value){
        delete(key);
        addToHead(key, value);
    }
    public void delete(){
        cache.remove(tail.pre.key);
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
    }
    public void delete(int key){
        DLinkedNode node = cache.get(key);
        cache.remove(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
