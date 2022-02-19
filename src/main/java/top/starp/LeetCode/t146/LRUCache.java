package top.starp.LeetCode.t146;

import java.util.*;

class LRUCache {

    //Map<Integer,Integer>map=new HashMap<>();
    Map<Integer,DLinkedNode>map=new HashMap<>();
    //List<Map<Integer,Integer>>list=new LinkedList<>();
    LinkedList<Integer>list=new LinkedList<>();
    private final DLinkedNode dummyTail;
    private final DLinkedNode dummyHead;

    //DLinkedNode dummyHead=new DLinkedNode();
    //DLinkedNode dummyTail=new DLinkedNode();
    //List<Integer>list=new LinkedList<>();
    int capacity;
    int size=0;
    public LRUCache(int capacity) {
        //List<Map<Integer,Integer>>list=new LinkedList<>();

        DLinkedNode head=new DLinkedNode();
        DLinkedNode tail=new DLinkedNode();
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();
        dummyHead.next=head;
        head.next=tail;
        tail.next= dummyTail;
      this.  capacity=capacity;

    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    void removeNode(DLinkedNode dLinkedNode){
        //dLinkedNode.next=dLinkedNode.next.next;
        DLinkedNode next=dLinkedNode.next;
        DLinkedNode pre=dLinkedNode.prev;
        pre.next=next;
        next.prev=pre;
    }

    void addToHead(DLinkedNode dLinkedNode){
        dLinkedNode.next=dummyHead.next.next;
        dummyHead.next=dLinkedNode;
    }
    void moveToHead(DLinkedNode dLinkedNode){
        removeNode(dLinkedNode);
        addToHead(dLinkedNode);
        //dLinkedNode.next=dummyHead.next;
        //dLinkedNode.next=dummyHead.next;
    }

    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    public int get(int key) {
        //Integer integer = map.get(key);
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode==null) {
            return -1;
        }
        //dLinkedNode.
        moveToHead(dLinkedNode);
        //if(integer==null){
        //    //没有 插入新的
        //    return -1;
        //}
        //list.remove(key);
        ////list.
        //list.addFirst(key);
        //return 1;
        return dLinkedNode.value;
    }
    
    public void put(int key, int value) {

        DLinkedNode dLinkedNode = map.get(key);
        if(dLinkedNode==null){
            DLinkedNode dLinkedNode1 = new DLinkedNode(key, value);
            //放在头
            //mo
            addToHead(dLinkedNode1);
            return;
        }
        moveToHead(dLinkedNode);
        size++;
        if(capacity>size){
            rmTail();
            size--;
        }
    }

    void rmTail(){
        DLinkedNode pre=dummyTail.prev.prev;
        pre.next=dummyTail;

        dummyTail.prev=pre;
    }

    public static void main(String[] args) {
        System.out.println(22-66+100);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */