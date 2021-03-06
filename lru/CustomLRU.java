package lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/*
      pre <- key/value -> next

      Maintain a map and a doublely linked List

 */


class LRUNode
{
    int key;
    int value;
    LRUNode pre;
    LRUNode next;

    LRUNode(int k, int v)
    {
        key =k;
        value = v;
        pre = null;
        next = null;
    }

}

class LRUCache {
    int capacity = 5;
    Map<Integer,LRUNode> map;
    LRUNode head;
    LRUNode tail;

    public LRUCache(int capacity)
    {
        head = null;
        tail = null;
        map = new HashMap<Integer,LRUNode>(capacity);
    }

    private void remove(LRUNode node)
    {
        if(node.pre != null)
        {
            node.pre.next = node.next;
        }
        else
        {
            head = node.next;
        }

        if(node.next!= null)
        {
            node.next.pre = node.pre;
        }
        else
        {
            tail = node.pre;
        }
    }

    private void update(LRUNode node)
    {
        node.next =head;
        node.pre = null;

        if(head !=null)
            head.pre = node;

        head = node;

        if(tail == null)
            tail = head;

    }

    public int get(int key)
    {
        if(map.containsKey(key))
        {
            LRUNode node = map.get(key);
            remove(node);
            update(node);
            return node.value;
        }
        return Integer.MIN_VALUE;
    }

    public void set(int key, int value) {

        if(map.containsKey(key))
        {
            LRUNode node = map.get(key);
            node.value = value;
            remove(node);
            update(node);
        }
        else
        {
            LRUNode  node = new LRUNode(key,value);
            if(map.size()>=capacity)
            {
                map.remove(tail.key);
                remove(tail);
                update(node);
            }
            else
            {
                update(node);
            }
            map.put(key,node);
        }

    }
}


class LRULinkedHashMap  extends LinkedHashMap
{
    int capacity =5;

    LRULinkedHashMap(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}

class LRUCustomLRU
{
    public static void main(String args[])
    {

       /* LRUCache cache = new LRUCache(5);
        cache.set(1,10);
        cache.set(2,20);
        cache.set(3,30);
        cache.set(4,40);
        cache.set(5,50);
        cache.set(6,60);

        System.out.println(cache.get(1));*/


        LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap(5);
        lruLinkedHashMap.put(1,10);
        lruLinkedHashMap.put(2,20);
        lruLinkedHashMap.put(3,30);
        lruLinkedHashMap.put(4,40);
        lruLinkedHashMap.put(5,50);
        lruLinkedHashMap.put(6,60);

        System.out.println(lruLinkedHashMap.get(3));
    }
}
