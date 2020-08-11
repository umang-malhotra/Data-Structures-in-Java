package Misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementation {
    public static void main(String[] args) {
        LRUCache lruCache  = new LRUCache(4);
        lruCache.set(1,31);
        lruCache.set(2,32);
        lruCache.set(3,33);
        System.out.println(lruCache.get(1));
        lruCache.set(1, 111);
        lruCache.set(4,34);
        lruCache.set(5,35);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}

class LRUCache
{
    final static Node head = new Node();
    final static Node tail = new Node();
    static Map<Integer, Node> node_map;
    static int cache_capacity;

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    LRUCache(int cap)
    {
        // Intialize the cache capacity with the given
        // cap
        node_map = new HashMap<Integer, Node>(cap);
        this.cache_capacity = cap;
        head.next = tail;
        tail.prev = head;
    }

    // This method works in O(1)
    public static int get(int key)
    {
        // your code here
        int result = -1;
        Node node = node_map.get(key);
        if(node != null) {
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        Node node = node_map.get(key);
        if(node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if(node_map.size() == cache_capacity) {
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.value = value;

            add(new_node);
            node_map.put(key, new_node);
        }
        // your code here
    }

    private static void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;

        prev_node.next = next_node;
        next_node.prev = prev_node;
    }

    private static void add(Node node) {
        Node head_next = head.next;

        node.next = head_next;
        node.prev = head;
        head_next.prev = node;
        head.next = node;
    }
}

